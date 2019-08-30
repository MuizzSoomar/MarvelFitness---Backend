package com.marvelfitness.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint for getting a list of all Users
     * @return list of all Users in database
     */
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint for getting a User by user_id
     * @return User data with given user_id
     */
    @RequestMapping("/users/{user_id}")
    public User getUserById(@PathVariable int user_id) {
        return userService.getUserById(user_id);
    }

    /**
     * Endpoint for User search functionality
     * @param name User name
     * @param email User email
     * @return User data with given name, email, or list of all Users if no matches found
     */
    @RequestMapping(value = "/users/search")
    public List<User> searchForUser(@RequestParam(value="name", required=false, defaultValue = "") String name,
                                            @RequestParam(value="email", required=false, defaultValue = "") String email) {
        return userService.searchForUser(name, email);
    }

    /**
     * Endpoint for adding a new User to the database
     * @param user new User info to add
     */
    @RequestMapping(method= RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * Endpoint for updating a given User's information in the database
     * @param user new User object with updated information
     * @param user_id id of User to update
     */
    @RequestMapping(method=RequestMethod.PUT, value="/users/{user_id}")
    public void updateUser(@RequestBody User user, @PathVariable int user_id) {
        userService.updateUser(user, user_id);
    }

    /**
     * Endpoint for deleting a User with the given id from the database
     * @param user_id id of User to delete
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/users/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        userService.deleteUser(user_id);
    }

}
