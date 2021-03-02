<?php

namespace App\Repositories\Organization;

use App\User;
use App\Models\Organization;
use App\Repositories\EloquentRepositoryInterface;

interface OrganizationRepositoryInterface extends EloquentRepositoryInterface
{
    /**
     * To fetch suborganizations
     *
     * @param $parent_id
     * @return Organization $organizations
     */
    public function fetchSuborganizations($parent_id);

    /**
     * To create a suborganization
     *
     * @param Organization $organization
     * @param $data
     */
    public function createSuborganization($organization, $data);

    /**
     * To delete a suborganization
     *
     * @param $id
     */
    public function deleteSuborganization($id);

    /**
     * To get the users to add in specific suborganization
     *
     * @param $data
     * @param Organization $organization
     * @return mixed
     */
    public function getMemberOptions($data, $organization);

    /**
     * Add user for the specified role in default suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function addUser($organization, $data);

    /**
     * Update user for the specified role in particular suborganization
     *
     * @param Organization $organization
     * @param array $data
     * @return Model
     */
    public function updateUser($organization, $data);

    /**
     * Delete the specified user in a particular suborganization
     *
     * @param $id
     * @param array $data
     * @return Model
     */
    public function deleteUser($id, $data);

    /**
     * To fetch organization users
     *
     * @param Organization $organization
     * @return Model
     */
    public function fetchOrganizationUsers($organization);

    /**
     * Get admin
     *
     * @param Organization $organization
     * @return Model
     */
    public function getAdmin($organization);

    /**
     * Invite member to the organization
     *
     * @param User $authenticatedUser
     * @param Organization $organization
     * @param $data
     * @return bool
     */
    public function inviteMember($authenticatedUser, $organization, $data);
}