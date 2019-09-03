package com.marvelfitness.portal.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findUsersByName(String name);

    List<User> findUsersByEmail(String email);
}
