package com.marvelfitness.portal.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{customer_id}")
    public Customer getCustomer(@PathVariable int customer_id) {
        return customerService.getCustomer(customer_id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/customers")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/customers/{customer_id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable int customer_id) {
        customerService.updateCustomer(customer, customer_id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{customer_id}")
    public void deleteCustomer(@PathVariable int customer_id) {
        customerService.deleteCustomer(customer_id);
    }

}
