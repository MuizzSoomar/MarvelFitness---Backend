package com.marvelfitness.portal.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * User Repository interface used to access the user_table in the database
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Method to find Users that match the provided name
     * @param name name of User(s) to find
     * @return a list of all Users who match the provided name
     */
    List<User> findUsersByName(String name);

    /**
     * Method to find Users that match the provided username
     * @param username username of User(s) to find
     * @return a list of all Users who match the provided username
     */
    List<User> findUsersByUsername(String username);

    /**
     * Method to find a User that matches the provided username
     * @param username username of User to find
     * @return a User wrapped by an Optional
     */
    Optional<User> findByUsername(String username);
}
