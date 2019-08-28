package com.marvelfitness.portal.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Endpoint for getting a list of all Customers
     * @return list of all Customers in database
     */
    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Endpoint for getting a Customer by customer_id
     * @return Customer data with given customer_id
     */
    @RequestMapping("/customers/{customer_id}")
    public Customer getCustomerById(@PathVariable int customer_id) {
        return customerService.getCustomerById(customer_id);
    }

    /**
     * Endpoint for adding a new Customer to the database
     * @param customer new Customer info to add
     */
    @RequestMapping(method= RequestMethod.POST, value="/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    /**
     * Endpoint for updating a given Customer's information in the database
     * @param customer new Customer object with updated information
     * @param customer_id id of Customer to update
     */
    @RequestMapping(method=RequestMethod.PUT, value="/customers/{customer_id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int customer_id) {
        customerService.updateCustomer(customer, customer_id);
    }

    /**
     * Endpoint for deleting a Customer with the given id from the database
     * @param customer_id id of Customer to delete
     */
    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{customer_id}")
    public void deleteCustomer(@PathVariable int customer_id) {
        customerService.deleteCustomer(customer_id);
    }

}
