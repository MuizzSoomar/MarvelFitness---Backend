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

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1001, "Tony Stark", "ironman@gmail.com", "password1"),
            new Customer(1002, "Peter Parker", "spiderman@gmail.com", "password2"),
            new Customer(1003, "Steve Rogers", "captainamerica@gmail.com", "password3")
        ));

    public List<Customer> getAllCustomers() {
//        return customers;
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(int customer_id) {
        return customerRepository.findById(customer_id).orElse(null);

    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer, int customer_id) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(int customer_id) {
        customerRepository.deleteById(customer_id);
    }
}
