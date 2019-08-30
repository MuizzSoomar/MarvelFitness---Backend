package com.marvelfitness.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Gets a list of all Users from the database
     * @return list of all Users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    /**
     * Gets an individual User from the database with a given id
     * @param user_id id of User
     * @return User with given id
     */
    public User getUserById(int user_id) {
        return userRepository.findById(user_id).orElse(null);

    }

    /**
     * Search functionality for Users
     * Will find all Users that match a given name or email, or a list of all Users if none are found
     * @param name User name
     * @param email User email
     * @return list of Users that match parameters
     */
    public List<User> searchForUser(String name, String email) {

        //create an empty list to hold all users found by the search query
        List<User> users = new ArrayList<>();

        //add users by name if given as a parameter
        if (name != "") {
            userRepository.findUsersByName(name).forEach(users::add);
        }

        //add users by email if given as a parameter
        if (email != "") {
            userRepository.findUsersByEmail(email).forEach(users::add);
        }

        //create a list of all users if none are found with the given parameters
        if (users.size() == 0) {
            userRepository.findAll().forEach(users::add);
        }

        return users;
    }

    /**
     * Adds a new User to the database
     * @param user new User to add
     */
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * Updates the given User's entry in the database
     * @param user User to update
     * @param user_id id of User to update
     */
    public void updateUser(User user, int user_id) {
        userRepository.save(user);
    }

    /**
     * Deletes the given User from the database
     * @param user_id id of User to delete
     */
    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);
    }
}
