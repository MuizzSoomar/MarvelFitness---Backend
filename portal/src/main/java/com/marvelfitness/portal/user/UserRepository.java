package com.marvelfitness.portal.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findUsersByName(String name);

    List<User> findUsersByUsername(String username);

    Optional<User> findByUsername(String username);

}
