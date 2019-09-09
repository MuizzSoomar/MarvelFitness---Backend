package com.marvelfitness.portal.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Role Repository interface used to access the roles table in the database
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {

    /**
     * Method to find a Role that matches the provided roleName
     * @param roleName name of Role to find
     * @return a Role wrapped by an Optional
     */
    Optional<Role> findByName(RoleName roleName);
}
