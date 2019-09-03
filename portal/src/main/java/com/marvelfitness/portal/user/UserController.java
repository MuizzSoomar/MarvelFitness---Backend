package com.marvelfitness.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint for getting a list of all Users
     * @return list of all Users in database
     */
    @RequestMapping(method=RequestMethod.GET, value="/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Endpoint for getting a list of all Customers
     * @return list of all Customers in database
     */
    @RequestMapping(method=RequestMethod.GET, value="/customers")
    public List<User> getAllCustomers() {
        return userService.getAllCustomers();
    }

    /**
     * Endpoint for getting a list of all Employees
     * @return list of all Employees in database
     */
    @RequestMapping(method=RequestMethod.GET, value="/employees")
    public List<User> getAllEmployees() {
        return userService.getAllEmployees();
    }

    /**
     * Endpoint for getting a Customer by user_id
     * @return Customer data with given user_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/customers/{user_id}")
    public User getCustomerById(@PathVariable int user_id) {
        return userService.getCustomerById(user_id);
    }

    /**
     * Endpoint for getting a Employee by user_id
     * @return Employee data with given user_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/employees/{user_id}")
    public User getEmployeeById(@PathVariable int user_id) {
        return userService.getEmployeeById(user_id);
    }

    /**
     * Endpoint for Customer search functionality
     * @param name Customer name
     * @param email Customer email
     * @return User data with given name, email, or list of all Users if no matches found
     */
    @RequestMapping(method=RequestMethod.GET, value="/customers/search")
    public List<User> searchForCustomer(@RequestParam(value="name", required=false, defaultValue = "") String name,
                                        @RequestParam(value="email", required=false, defaultValue = "") String email) {
        return userService.searchForCustomer(name, email);
    }

    /**
     * Endpoint for adding a new User to the database
     * @param user new User info to add
     */
    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * Endpoint for deleting a User with the given id from the database
     * @param user_id id of User to delete
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/users/{user_id}")
    public void deleteUser(@PathVariable int user_id) {
        userService.deleteUser(user_id);
    }

    /**
     * Endpoint for updating a Customer's reward balance
     * @param user_id id of Customer to update
     * @param new_balance new reward balance
     */
    @RequestMapping(method=RequestMethod.POST, value="/customers/update_balance/{user_id}")
    public void updateBalance(@PathVariable int user_id,
                              @RequestParam(value="new_balance", defaultValue="5") short new_balance) {
        userService.updateRewardsBalance(user_id, new_balance);
    }

}
