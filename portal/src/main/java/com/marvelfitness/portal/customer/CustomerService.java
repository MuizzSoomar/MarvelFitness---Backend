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
