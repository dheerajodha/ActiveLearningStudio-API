package org.curriki.api.enus.staticclasses;

/**
 * ContentType: text/plain
 * DisplayName.enUS: ActiveLearningStudio-API/pom.xml
 * Map.hackathonLabel: create_java_class_Pom
 * Map.hackathonMission: Create the file ActiveLearningStudio-API/pom.xml
 * Map.hackathonTitle: create a pom.xml file for managing Java depencies in the project. 
 * Map.hackathonColumn: Develop Base Classes
 * Map.hackathonLabels: Java,Maven
 * enUS: Define the groupId and artifactId for ActiveLearningStudio-API. 
 * enUS: Define properties for maven. 
 * enUS: Define the managed dependencies for maven. 
 * enUS: Define the dependencies for maven. 
 * enUS: Define the build plugins for Maven. 
 */
public class Pom {

	/**
	 * DisplayName.enUS: Define the groupId and artifactId for ActiveLearningStudio-API. 
	 * enUS: Create a new file: /usr/local/src/ActiveLearningStudio-API/pom.xml
	 * enUS: 
	 * enUS: 
	 */
	public void part1() {
//<?xml version="1.0" encoding="UTF-8"?>
//<!-- 
//Define the groupId and artifactId for ActiveLearningStudio-API. 
//-->
//<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
//	<modelVersion>4.0.0</modelVersion>
//	<groupId>org.curriki.api</groupId>
//	<artifactId>ActiveLearningStudio-API</artifactId>
//	<version>1.0.0-SNAPSHOT</version>
//	<name>ActiveLearningStudio-API</name>
//	<description></description>
	}

	/**
	 * DisplayName.enUS: Define properties for maven. 
	 * enUS: 
	 */
	public void part2() {
//
//	<!-- 
//	Define properties for maven. 
//	-->
//	<properties>
//		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
//		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
//		<maven.min.version>3.3.9</maven.min.version>
//		<maven.compiler.source>1.8</maven.compiler.source>
//		<maven.compiler.target>1.8</maven.compiler.target>
//		<jdk.min.version>${maven.compiler.source}</jdk.min.version>
//		<junit.version>4.13.1</junit.version>
//		<kafka.version>1.0.0</kafka.version>
//		<maven-compiler-plugin.version>3.8.0</maven-compiler-plugin.version>
//		<maven-surefire-plugin.version>2.19.1</maven-surefire-plugin.version>
//		<maven-war-plugin.version>2.3</maven-war-plugin.version>
//		<maven-shade-plugin.version>3.2.4</maven-shade-plugin.version>
//		<maven-jarsigner-plugin.version>1.4</maven-jarsigner-plugin.version>
//		<properties-maven-plugin.version>1.0.0</properties-maven-plugin.version>
//		<postgresql.version>42.2.2.jre7</postgresql.version>
//		<solr.version>8.4.1</solr.version>
//		<vertx-maven-plugin.version>1.0.9</vertx-maven-plugin.version>
//		<build-helper-maven-plugin.version>3.0.0</build-helper-maven-plugin.version>
//		<exec-maven-plugin.version>1.5.0</exec-maven-plugin.version>
//		<vertx.version>4.0.3</vertx.version>
//		<quarkus-plugin.version>2.2.2.Final</quarkus-plugin.version>
//		<quarkus.platform.artifact-id>quarkus-bom</quarkus.platform.artifact-id>
//		<quarkus.platform.group-id>io.quarkus</quarkus.platform.group-id>
//		<quarkus.platform.version>2.2.2.Final</quarkus.platform.version>
//		<apache-curator.version>4.3.0</apache-curator.version>
//	</properties>
	}

	/**
	 * DisplayName.enUS: Define the managed dependencies for maven. 
	 * enUS: 
	 */
	public void part3() {
//
//	<!-- 
//	Define the managed dependencies for maven. 
//	-->
//	<dependencyManagement>
//		<dependencies>
//
//			<dependency>
//				<groupId>io.vertx</groupId>
//				<artifactId>vertx-dependencies</artifactId>
//				<version>${vertx.version}</version>
//				<type>pom</type>
//				<scope>import</scope>
//			</dependency>
//
//			<dependency>
//				<groupId>${quarkus.platform.group-id}</groupId>
//				<artifactId>${quarkus.platform.artifact-id}</artifactId>
//				<version>${quarkus.platform.version}</version>
//				<type>pom</type>
//				<scope>import</scope>
//			</dependency>
//		</dependencies>
//	</dependencyManagement>
	}

	/**
	 * DisplayName.enUS: Define the dependencies for maven. 
	 * enUS: 
	 */
	public void part4() {
//
//	<!-- 
//	Define the dependencies for maven. 
//	-->
//	<dependencies>
//
//		<!-- ############## -->
//		<!-- Apache Commons -->
//		<!-- ############## -->
//
//		<dependency>
//			<groupId>commons-beanutils</groupId>
//			<artifactId>commons-beanutils</artifactId>
//			<version>1.9.4</version>
//		</dependency>
//
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-configuration2</artifactId>
//			<version>2.7</version>
//		</dependency>
//
//		<dependency>
//			<groupId>commons-dbutils</groupId>
//			<artifactId>commons-dbutils</artifactId>
//			<version>1.7</version>
//		</dependency>
//
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-exec</artifactId>
//			<version>1.3</version>
//		</dependency>
//
//		<dependency>
//			<groupId>org.apache.commons</groupId>
//			<artifactId>commons-text</artifactId>
//			<version>1.8</version>
//		</dependency>
//
//		<!-- ####### -->
//		<!-- Quarkus -->
//		<!-- ####### -->
//
//		<dependency>
//			<groupId>io.quarkus</groupId>
//			<artifactId>quarkus-resteasy-reactive-jackson</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>io.quarkus</groupId>
//			<artifactId>quarkus-vertx</artifactId>
//			<exclusions>
//				<exclusion>
//					<groupId>org.jboss.slf4j</groupId>
//					<artifactId>slf4j-jboss-logmanager</artifactId>
//				</exclusion>
//			</exclusions>
//		</dependency>
//		<dependency>
//			<groupId>io.smallrye.reactive</groupId>
//			<artifactId>smallrye-mutiny-vertx-web-client</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>io.quarkus</groupId>
//			<artifactId>quarkus-arc</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>io.quarkus</groupId>
//			<artifactId>quarkus-junit5</artifactId>
//			<scope>test</scope>
//			<exclusions>
//				<exclusion>
//					<groupId>org.jboss.slf4j</groupId>
//					<artifactId>slf4j-jboss-logmanager</artifactId>
//				</exclusion>
//			</exclusions>
//		</dependency>
//		<dependency>
//			<groupId>io.rest-assured</groupId>
//			<artifactId>rest-assured</artifactId>
//			<scope>test</scope>
//		</dependency>
//
//		<!-- Extra -->
//		<dependency>
//			<groupId>io.quarkus</groupId>
//			<artifactId>quarkus-reactive-pg-client</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>io.smallrye.reactive</groupId>
//			<artifactId>smallrye-mutiny-vertx-web</artifactId>
//		</dependency>
//
//		<!-- ########## -->
//		<!-- PostgreSQL -->
//		<!-- ########## -->
//
//		<dependency>
//			<groupId>org.postgresql</groupId>
//			<artifactId>postgresql</artifactId>
//			<version>${postgresql.version}</version>
//		</dependency>
//
//		<!-- #### -->
//		<!-- Solr -->
//		<!-- #### -->
//
//		<dependency>
//			<groupId>org.apache.solr</groupId>
//			<artifactId>solr-core</artifactId>
//			<version>${solr.version}</version>
//			<exclusions>
//				<exclusion>
//					<groupId>org.apache.logging.log4j</groupId>
//					<artifactId>log4j-core</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>org.apache.logging.log4j</groupId>
//					<artifactId>log4j-api</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>org.apache.logging.log4j</groupId>
//					<artifactId>log4j-1.2-api</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>org.apache.logging.log4j</groupId>
//					<artifactId>log4j-slf4j-impl</artifactId>
//				</exclusion>
//				<exclusion>
//					<groupId>org.apache.logging.log4j</groupId>
//					<artifactId>log4j-web</artifactId>
//				</exclusion>
//			</exclusions>
//		</dependency>
//
//		<dependency>
//			<groupId>org.apache.solr</groupId>
//			<artifactId>solr-solrj</artifactId>
//			<version>${solr.version}</version>
//		</dependency>
//
//		<!-- ################# -->
//		<!-- Flying Saucer PDF -->
//		<!-- ################# -->
//
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-core</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-swt</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//
//		<dependency>
//			<groupId>org.xhtmlrenderer</groupId>
//			<artifactId>flying-saucer-pdf-itext5</artifactId>
//			<version>9.1.19</version>
//		</dependency>
//
//		<dependency>
//			<groupId>com.github.librepdf</groupId>
//			<artifactId>openpdf</artifactId>
//			<version>1.3.11</version>
//		</dependency>
//
//		<dependency>
//			<groupId>com.itextpdf</groupId>
//			<artifactId>itext-asian</artifactId>
//			<version>5.2.0</version>
//		</dependency>
//
//		<!-- ###### -->
//		<!-- Vert.X -->
//		<!-- ###### -->
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-core</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-templ-handlebars</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-zookeeper</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-pg-client</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-auth-oauth2</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-reactive-streams</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-openapi</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-codegen</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-service-proxy</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-api-service</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-web-client</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-mail-client</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-jdbc-client</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-config</artifactId>
//		</dependency>
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-config-yaml</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.vertx</groupId>
//			<artifactId>vertx-health-check</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>io.opentracing.contrib</groupId>
//			<artifactId>opentracing-vertx-web</artifactId>
//			<version>0.1.0</version>
//		</dependency>
//
//		<dependency>
//			<groupId>io.opentracing.contrib</groupId>
//			<artifactId>opentracing-solr-client</artifactId>
//			<version>0.1.0</version>
//		</dependency>
//
//		<!-- ###### -->
//		<!-- Charts -->
//		<!-- ###### -->
//
//		<dependency>
//			<groupId>org.jfree</groupId>
//			<artifactId>jfreechart</artifactId>
//			<version>1.5.0</version>
//		</dependency>
//
//		<!-- ######### -->
//		<!-- Zookeeper -->
//		<!-- ######### -->
//
//		<dependency>
//			<groupId>org.apache.curator</groupId>
//			<artifactId>curator-client</artifactId>
//			<version>${apache-curator.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>org.apache.curator</groupId>
//			<artifactId>curator-framework</artifactId>
//			<version>${apache-curator.version}</version>
//		</dependency>
//		<dependency>
//			<groupId>org.apache.curator</groupId>
//			<artifactId>curator-recipes</artifactId>
//			<version>${apache-curator.version}</version>
//		</dependency>
//
//		<!-- ############ -->
//		<!-- Unit Testing -->
//		<!-- ############ -->
//
//		<dependency>
//			<groupId>junit</groupId>
//			<artifactId>junit</artifactId>
//			<version>${junit.version}</version>
//			<scope>test</scope>
//		</dependency>
//	</dependencies>
	}

	/**
	 * DisplayName.enUS: Define the build plugins for Maven. 
	 * enUS: 
	 */
	public void part5() {
//
//	<!-- 
//	Define the build plugins for Maven. 
//	 -->
//	<build>
//		<resources>
//			<resource>
//				<directory>src/main/resources</directory>
//			</resource>
//		</resources>
//		<plugins>
//			<plugin>
//				<groupId>org.springframework.boot</groupId>
//				<artifactId>spring-boot-maven-plugin</artifactId>
//			</plugin>
//			<plugin>
//				<artifactId>maven-compiler-plugin</artifactId>
//				<version>${maven-compiler-plugin.version}</version>
//				<configuration>
//					<target>1.8</target>
//					<source>1.8</source>
//					<annotationProcessors>
//						<annotationProcessor>io.vertx.codegen.CodeGenProcessor</annotationProcessor>
//					</annotationProcessors>
//				</configuration>
//			</plugin>
//			<plugin>
//				<groupId>org.codehaus.mojo</groupId>
//				<artifactId>build-helper-maven-plugin</artifactId>
//				<version>${build-helper-maven-plugin.version}</version>
//				<executions>
//					<execution>
//						<phase>generate-sources</phase>
//						<goals>
//							<goal>add-source</goal>
//						</goals>
//						<configuration>
//							<sources>
//								<source>src/gen/java</source>
//								<source>target/generated-sources/annotations</source>
//							</sources>
//						</configuration>
//					</execution>
//				</executions>
//			</plugin>
//		</plugins>
//	</build>
//</project>
	}
}
