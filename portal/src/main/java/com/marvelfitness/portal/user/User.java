package com.marvelfitness.portal.user;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


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
//    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * Default constructor of User object
     */
    public User() {
        this.user_id = 000;
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
     * @param name name of User
     * @param username email of User
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public short getRewards_balance() {
        return rewards_balance;
    }

    public void setRewards_balance(short rewards_balance) {
        this.rewards_balance = rewards_balance;
    }

    public String getStreet_one() {
        return street_one;
    }

    public void setStreet_one(String street_one) {
        this.street_one = street_one;
    }

    public String getStreet_two() {
        return street_two;
    }

    public void setStreet_two(String street_two) {
        this.street_two = street_two;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public Set<Role> getRoles() { return roles; }

    public void setRoles(Set<Role> roles)  { this.roles = roles; }

}
