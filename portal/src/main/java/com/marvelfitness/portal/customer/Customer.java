package com.marvelfitness.portal.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;
    private String name;
    private String email;
    private String phone_number;
    private short rewards_balance;
    private String street_one;
    private String street_two;
    private String city;
    private String state;
    private String zip;
    private String password;

    /**
     * Default constructor of Customer object
     */
    public Customer() {
        this.customer_id = 000;
        this.name = "John Smith";
        this.email = "john.smith@mailinator.com";
        this.phone_number = "1234567890";
        this.rewards_balance = 0;
        this.street_one = "123 Main St";
        this.street_two = null;
        this.city = "New York";
        this.state = "NY";
        this.zip = "12345";
        this.password = "password";
    }

    /**
     * Constructor to build a new Customer object with all parameters
     * @param name name of Customer
     * @param email email of Customer
     * @param phone_number phone number of Customer
     * @param rewards_balance rewards balance of Customer
     * @param street_one street name of Customer
     * @param street_two additional street name of Customer
     * @param city city of Customer
     * @param state state of Customer
     * @param zip zip code of Customer
     * @param password password of Customer
     */
    public Customer(int customer_id, String name, String email, String phone_number, short rewards_balance, String street_one,
                    String street_two, String city, String state, String zip, String password) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.rewards_balance = rewards_balance;
        this.street_one = street_one;
        this.street_two = street_two;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
