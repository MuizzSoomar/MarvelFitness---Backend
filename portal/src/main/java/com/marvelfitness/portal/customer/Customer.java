package com.marvelfitness.portal.customer;


public class Customer {

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

    public Customer(int customer_id, String name, String email, String password) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.phone_number = "0000000000";
        this.rewards_balance = 0;
        this.street_one = "Street 1";
        this.street_two = "Street 2";
        this.city = "City";
        this.state = "ST";
        this.zip = "00000";
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
