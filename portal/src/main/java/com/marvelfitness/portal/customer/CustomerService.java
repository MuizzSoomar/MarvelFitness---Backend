package com.marvelfitness.portal.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Gets a list of all Customers from the database
     * @return list of all Customers
     */
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    /**
     * Gets an individual Customer from the database with a given id
     * @param customer_id id of Customer
     * @return Customer with given id
     */
    public Customer getCustomerById(int customer_id) {
        return customerRepository.findById(customer_id).orElse(null);

    }

    /**
     * Search functionality for Customers
     * Will find all Customers that match a given name or email, or a list of all Customers if none are found
     * @param name Customer name
     * @param email Customer email
     * @return list of Customers that match parameters
     */
    public List<Customer> searchForCustomer(String name, String email) {

        //create an empty list to hold all customers found by the search query
        List<Customer> customers = new ArrayList<>();

        //add customers by name if given as a parameter
        if (name != "") {
            customerRepository.findCustomersByName(name).forEach(customers::add);
        }

        //add customers by email if given as a parameter
        if (email != "") {
            customerRepository.findCustomersByEmail(email).forEach(customers::add);
        }

        //create a list of all customers if none are found with the given parameters
        if (customers.size() == 0) {
            customerRepository.findAll().forEach(customers::add);
        }

        return customers;
    }
//
//    public Customer getCustomerByName(String name) {
//        return customerRepository.findCustomerByName(name);
//    }
//
//    public Customer getCustomerByEmail(String email) {
//        return customerRepository.findCustomerByEmail(email);
//    }

    /**
     * Adds a new Customer to the database
     * @param customer new Customer to add
     */
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Updates the given Customer's entry in the database
     * @param customer Customer to update
     * @param customer_id id of Customer to update
     */
    public void updateCustomer(Customer customer, int customer_id) {
        customerRepository.save(customer);
    }

    /**
     * Deletes the given Customer from the database
     * @param customer_id id of Customer to delete
     */
    public void deleteCustomer(int customer_id) {
        customerRepository.deleteById(customer_id);
    }
}
