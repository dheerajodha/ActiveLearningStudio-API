<?php

namespace App\Repositories\Organization;

use App\Models\Organization;
use App\Repositories\Organization\OrganizationRepositoryInterface;
use App\Repositories\BaseRepository;
use App\Repositories\User\UserRepositoryInterface;
use Illuminate\Support\Arr;
use App\Notifications\OrganizationInvite;
use App\Repositories\InvitedOrganizationUser\InvitedOrganizationUserRepositoryInterface;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;
use App\User;
use Illuminate\Support\Facades\DB;

class OrganizationRepository extends BaseRepository implements OrganizationRepositoryInterface
{
    private $userRepository;
    private $invitedOrganizationUserRepository;

    /**
     * Organization Repository constructor.
     *
     * @param Organization $model
     * @param UserRepositoryInterface $userRepository
     * @param InvitedOrganizationUserRepositoryInterface $invitedOrganizationUserRepository
     */
    public function __construct(
        Organization $model,
        UserRepositoryInterface $userRepository,
        InvitedOrganizationUserRepositoryInterface $invitedOrganizationUserRepository
    )
    {
        $this->userRepository = $userRepository;
        parent::__construct($model);
        $this->invitedOrganizationUserRepository = $invitedOrganizationUserRepository;
    }

    /**
     * To fetch suborganizations
     *
     * @param $parent_id
     * @return Organization $organizations
     */
    public function fetchSuborganizations($parent_id)
    {
        return $this->model
                ->with(['parent', 'admins'])
                ->withCount(['projects', 'children', 'users', 'groups', 'teams'])
                ->where('parent_id', $parent_id)
                ->get();
    }

    /**
     * To create a suborganization
     *
     * @param Organization $organization
     * @param $data
     * @return Response
     * @throws GeneralException
     */
    public function createSuborganization($organization, $data)
    {
        $userRoles = array_fill_keys($data['admins'], ['organization_role_type_id' => 1]);

        foreach ($data['users'] as $user) {
            $userRoles[$user['user_id']] = ['organization_role_type_id' => $user['role_id']];
        }

        try {
            DB::beginTransaction();

            $suborganization = $organization->children()->create(Arr::except($data, ['admins', 'users']));

            if ($suborganization) {
                $suborganization->users()->sync($userRoles);
                DB::commit();
            }

            return $suborganization;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
            DB::rollBack();
        }
    }

    /**
     * Update suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function update($organization, $data)
    {
        $userRoles = array_fill_keys($data['admins'], ['organization_role_type_id' => 1]);

        foreach ($data['users'] as $user) {
            $userRoles[$user['user_id']] = ['organization_role_type_id' => $user['role_id']];
        }

        try {
            DB::beginTransaction();

            $is_updated = $organization->update(Arr::except($data, ['admins', 'users']));
            // update the organization data
            if ($is_updated) {
                $organization->users()->sync($userRoles);
                DB::commit();
            }

            return $is_updated;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }
    }

    /**
     * Delete suborganization
     *
     * @param $id
     * @return Model
     */
    public function deleteSuborganization($id)
    {
        $organization = $this->find($id);

        try {
            foreach ($organization->children as $suborganization) {
                $this->deleteSuborganization($suborganization->id);
            }

            $is_deleted = $this->delete($id);
            return $is_deleted;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }
    }

    /**
     * Get the member options to add in specific suborganization
     *
     * @param $data
     * @param Organization $organization
     * @return mixed
     */
    public function getMemberOptions($data, $organization)
    {
        $userNotInIds = $organization->users->modelKeys();

        $userInIds = $this->getParentOrganizationUserIds([], $organization);

        $userInIds = array_diff($userInIds, $userNotInIds);

        $this->query = $this->userRepository->model->when($data['query'] ?? null, function ($query) use ($data) {
            $query->search(['email'], $data['query']);
            return $query;
        });

        return $this->query->whereNotIn('id', $userNotInIds)->whereIn('id', $userInIds)->orderBy('first_name', 'asc')->paginate();
    }

    /**
     * Get the parent organizations user ids
     *
     * @param $userIds
     * @param $organization
     * @return array
     */
    public function getParentOrganizationUserIds($userIds, $organization)
    {
        if ($parentOrganization = $organization->parent) {
            $ids = $parentOrganization->users->modelKeys();
            $userIds = array_merge($userIds, $ids);

            $userIds = $this->getParentOrganizationUserIds($userIds, $parentOrganization);
        }

        return $userIds;
    }

    /**
     * Add user for the specified role in particular suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function addUser($organization, $data)
    {
        try {
            $organization->users()->attach($data['user_id'], ['organization_role_type_id' => $data['role_id']]);

            return true;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }

        return false;
    }

    /**
     * Update user for the specified role in particular suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function updateUser($organization, $data)
    {
        try {
            $organization->users()->updateExistingPivot($data['user_id'], ['organization_role_type_id' => $data['role_id']]);

            return true;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }

        return false;
    }

    /**
     * Delete the specified user in a particular suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function deleteUser($organization, $data)
    {
        try {
            $organization->users()->detach($data['user_id']);

            return true;
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }

        return false;
    }

    /**
     * To fetch organization users
     *
     * @param Organization $organization
     * @return Model
     */
    public function fetchOrganizationUsers($organization)
    {
        return $organization->users()->withCount([
            'projects' => function ($query) use ($organization) {
                $query->where('organization_id', $organization->id);
            },
            'teams' => function ($query) use ($organization) {
                $query->where('organization_id', $organization->id);
            },
            'groups' => function ($query) use ($organization) {
                $query->where('organization_id', $organization->id);
            }
        ])
        ->paginate();
    }

    /**
     * Get admin
     *
     * @param Organization $organization
     * @return Model
     */
    public function getAdmin($organization)
    {
        try {
            if ($organization) {
                return $organization->users()->wherePivot('organization_role_type_id', 1)->first();
            }
        } catch (\Exception $e) {
            Log::error($e->getMessage());
        }
    }

    /**
     * Invite member to the organization
     *
     * @param User $authenticatedUser
     * @param Organization $organization
     * @param $data
     * @return bool
     */
    public function inviteMember($authenticatedUser, $organization, $data)
    {
        $invited = true;

        $user = $this->userRepository->findByField('email', $data['email']);
        $note = array_key_exists('note', $data) ? $data['note'] : '';

        if ($user) {
            $organization->users()->attach($user, ['organization_role_type_id' => $data['role_id']]);
            $user->notify(new OrganizationInvite($authenticatedUser, $organization, $token, $note));
        } elseif ($data['email']) {
            $token = Hash::make((string)Str::uuid() . date('D M d, Y G:i'));
            $temp_user = new User(['email' => $data['email']]);
            $temp_user->notify(new OrganizationInvite($authenticatedUser, $organization, $token, $note));

            $invited_user = array(
                'invited_email' => $data['email'],
                'organization_id' => $organization->id,
                'organization_role_type_id' => $data['role_id'],
                'token' => $token,
            );
            $this->invitedOrganizationUserRepository->create($invited_user);
        } else {
            $invited = false;
        }

        return $invited;
    }
}