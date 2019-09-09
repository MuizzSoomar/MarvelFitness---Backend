package com.marvelfitness.portal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/logout-user")
//    public void logout() {
//        userService.logout();
//    }

    @RequestMapping(method=RequestMethod.GET, value="/user-details/{username}")
    public Optional<User> getUserDetails(@PathVariable String username) {
        return userService.getUserDetails(username);
    }

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
     * Endpoint for getting a User by user_id
     * @param user_id id of User to find
     * @return Appropriate ResponseEntity with User data associated with given user_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/users/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable int user_id) {
        User user = userService.getUserById(user_id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }

    /**
     * Endpoint for getting a Customer by user_id
     * @param user_id id of User to find
     * @return Appropriate ResponseEntity with Customer data associated with given user_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/customers/{user_id}")
    public ResponseEntity<User> getCustomerById(@PathVariable int user_id) {
        User user = userService.getCustomerById(user_id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }

    /**
     * Endpoint for getting a Employee by user_id
     * @param user_id id of User to find
     * @return Appropriate ResponseEntity with Employee data associated with given user_id
     */
    @RequestMapping(method=RequestMethod.GET, value="/employees/{user_id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable int user_id) {
        User user = userService.getEmployeeById(user_id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }

    /**
     * Endpoint for Customer search functionality
     * @param name Customer name
     * @param username Customer email/username
     * @return User data with given name, email, or list of all Users if no matches found
     */
    @RequestMapping(method=RequestMethod.GET, value="/customers/search")
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'CUSTOMER')")
    public List<User> searchForCustomer(@RequestParam(value="name", required=false, defaultValue = "") String name,
                                        @RequestParam(value="username", required=false, defaultValue = "") String username) {
        return userService.searchForCustomer(name, username);
    }

    /**
     * Endpoint for adding a new User to the database
     * @param user new User to add
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
     * @return appropriate ResponseEntity (404 if invalid user_id, 200 if valid)
     */
    @RequestMapping(method=RequestMethod.POST, value="/customers/update_balance/{user_id}")
    public ResponseEntity updateBalance(@PathVariable int user_id,
                              @RequestParam(value="new_balance", defaultValue="5") short new_balance) {
        return userService.updateRewardsBalance(user_id, new_balance);
    }

    /**
     * Endpoint for emailing Customers when they redeem rewards points
     * @param reward_id id of reward redeemed
     * @param user_id id of Customer to email
     * @return appropriate ResponseEntity (404 if invalid user_id, 200 if valid)
     */
    @RequestMapping(method= RequestMethod.POST, value="/rewards/{reward_id}/email/{user_id}")
    public ResponseEntity sendEmail(@PathVariable int reward_id, @PathVariable int user_id) {
        return userService.sendEmail(user_id, reward_id);
    }
}
