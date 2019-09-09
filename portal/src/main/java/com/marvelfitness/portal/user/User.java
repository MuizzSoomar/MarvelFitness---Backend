package com.marvelfitness.portal.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User class to hold information for all site users. Users can either be customers or employees
 */
@Entity
@Table(name = "user_table", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String name;
    private String username;
    private String phone_number;
    private short rewards_balance;
    private String street_one;
    private String street_two;
    private String city;
    private String state;
    private String zip;
    private String password;
    private boolean isCustomer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * Default constructor of User object
     */
    public User() {
        this.user_id = 0;
        this.name = "John Smith";
        this.username = "john.smith@mailinator.com";
        this.phone_number = "1234567890";
        this.rewards_balance = 0;
        this.street_one = "123 Main St";
        this.street_two = null;
        this.city = "New York";
        this.state = "NY";
        this.zip = "12345";
        this.password = "password";
        this.isCustomer = true;
    }

    /**
     * Constructor to build a new User object with all parameters
     * @param user_id id of User
     * @param name name of User
     * @param username username of User
     * @param phone_number phone number of User
     * @param rewards_balance rewards balance of User
     * @param street_one street name of User
     * @param street_two additional street name of User
     * @param city city of User
     * @param state state of User
     * @param zip zip code of User
     * @param password password of User
     * @param isCustomer whether or not the User is a Customer
     */
    public User(int user_id, String name, String username, String phone_number, short rewards_balance, String street_one,
                    String street_two, String city, String state, String zip, String password, boolean isCustomer) {
        this.user_id = user_id;
        this.name = name;
        this.username = username;
        this.phone_number = phone_number;
        this.rewards_balance = rewards_balance;
        this.street_one = street_one;
        this.street_two = street_two;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.password = password;
        this.isCustomer = isCustomer;
    }

    /**
     * Method to access User's ID number
     * @return User's ID number
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Method to set User's ID number
     * @param user_id new ID number for user
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Method to access User's name
     * @return User's name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set User's name
     * @param name User's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to access User's username/email
     * @return User's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method to set User's username/email
     * @param username User's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method to access User's phone number
     * @return User's phone number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Method to set User's phone number
     * @param phone_number User's phone number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * Method to access User's reward balance
     * @return User's reward balance
     */
    public short getRewards_balance() {
        return rewards_balance;
    }

    /**
     * Method to set User's rewards balance. Rewards balance cannot be > 100 or < 0
     * @param rewards_balance User's rewards balance
     */
    public void setRewards_balance(short rewards_balance) {
        if (rewards_balance >= 0 && rewards_balance <= 100) {
            this.rewards_balance = rewards_balance;
        } else if (rewards_balance > 100) {
            this.rewards_balance = 100;
        } else {
            this.rewards_balance = 0;
        }
    }

    /**
     * Method to access User's street address
     * @return User's street address
     */
    public String getStreet_one() {
        return street_one;
    }

    /**
     * Method to set User's street address
     * @param street_one User's street address
     */
    public void setStreet_one(String street_one) {
        this.street_one = street_one;
    }

    /**
     * Method to access second line of User's street address
     * @return second line of User's street address
     */
    public String getStreet_two() {
        return street_two;
    }

    /**
     * Method to set second line of User's street address
     * @param street_two second line of User's street address
     */
    public void setStreet_two(String street_two) {
        this.street_two = street_two;
    }

    /**
     * Method to access city in User's address
     * @return User's city
     */
    public String getCity() {
        return city;
    }

    /**
     * Method to set city in User's address
     * @param city User's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Method to access state in User's address
     * @return User's state
     */
    public String getState() {
        return state;
    }

    /**
     * Method to set state in User's address
     * @param state User's state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Method to access User's zip code
     * @return User's zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Method to set User's zip code
     * @param zip User's zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Method to access User's password
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set User's password
     * @param password User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method to determine whether User is a customer
     * @return User's customer status
     */
    public boolean isCustomer() {
        return isCustomer;
    }

    /**
     * Method to set whether User is a customer
     * @param isCustomer User's customer status
     */
    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    /**
     * Method to access User's roles
     * @return User's roles
     */
    public Set<Role> getRoles() { return roles; }

    /**
     * Method to set User's roles
     * @param roles User's roles
     */
    public void setRoles(Set<Role> roles)  { this.roles = roles; }

}
