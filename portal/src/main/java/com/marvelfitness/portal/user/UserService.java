package com.marvelfitness.portal.user;

import com.marvelfitness.portal.rewards.Reward;
import com.marvelfitness.portal.rewards.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RewardService rewardService;

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
     * Gets a list of all Customers from the database
     * @return list of all Customers
     */
    public List<User> getAllCustomers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        users.removeIf(((Predicate<User>) User::isCustomer).negate());
        return users;
    }

    /**
     * Gets a list of all Employees from the database
     * @return list of all Employees
     */
    public List<User> getAllEmployees() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        users.removeIf(User::isCustomer);
        return users;
    }

    /**
     * Gets an individual User from the database with a given id
     * @param user_id id of User
     * @return User with given id, null if not found
     */
    public User getUserById(int user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    /**
     * Gets an individual Customer from the database with a given id
     * @param user_id id of User
     * @return Customer with given id, null if not a Customer
     */
    public User getCustomerById(int user_id) {
        User user = getUserById(user_id);
        if (user != null && user.isCustomer()) {
            return user;
        }
        return null;
    }

    /**
     * Gets an individual Employee from the database with a given id
     * @param user_id id of User
     * @return Employee with given id, null if not a Employee
     */
    public User getEmployeeById(int user_id) {
        User user = getUserById(user_id);
        if (user != null && !user.isCustomer()) {
            return user;
        }
        return null;
    }

    /**
     * Search functionality for Customers
     * Will find all Customers that match a given name or username, or a list of all Customers if none are found
     * @param name Customer name
     * @param username Customer username
     * @return list of Customers that match parameters
     */
    public List<User> searchForCustomer(String name, String username) {

        //create an empty list to hold all users found by the search query
        List<User> customers = new ArrayList<>();
        //add users by name if given as a parameter
        if (name != "") {
            userRepository.findUsersByName(name).forEach(customers::add);
        }
        //add users by username if given as a parameter
        if (username != "") {
            userRepository.findUsersByUsername(username).forEach(customers::add);
        }
        //remove all users who are not customers
        customers.removeIf(((Predicate<User>) User::isCustomer).negate());
        //create a list of all customers if none are found with the given parameters
        if (customers.size() == 0) {
            userRepository.findAll().forEach(customers::add);
            customers.removeIf(((Predicate<User>) User::isCustomer).negate());
        }

        return customers;
    }

    /**
     * Adds a new User to the database
     * @param user new User to add
     */
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * Deletes the given User from the database
     * @param user_id id of User to delete
     */
    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);
    }

    /**
     * Updates the rewards balance of the Customer
     * @param user_id id of Customer to update
     * @param new_balance new balance for Customer
     * @return appropriate ResponseEntity (404 if invalid user_id, 200 if valid)
     */
    public ResponseEntity updateRewardsBalance(int user_id, short new_balance) {
        User customer = getCustomerById(user_id);
        if (customer != null) {
            customer.setRewards_balance(new_balance);
            userRepository.save(customer);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    /**
     * Emails the Customer to confirm reward redemption
     * @param user_id id of Customer to username
     * @param reward_id id of Reward redeemed
     * @return appropriate ResponseEntity (404 if invalid user_id, 200 if valid)
     */
    public ResponseEntity sendEmail(int user_id, int reward_id) {
        User user = getCustomerById(user_id);
        if (user != null) {
            Reward reward = rewardService.getReward(reward_id);
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(user.getUsername());
            msg.setSubject("You have earned " + reward.getDescription());
            String message = "Dear " + user.getName() + ",\n\nCongratulations! You have earned " +
                    reward.getDescription() + "\n\nPlease show this username at your next visit to receive " +
                    "your reward!\n\nThank you,\nMarvel Fitness Management";
            msg.setText(message);

            javaMailSender.send(msg);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
