package com.marvelfitness.portal.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1001, "Tony Stark", "ironman@gmail.com", "password1"),
            new Customer(1002, "Peter Parker", "spiderman@gmail.com", "password2"),
            new Customer(1003, "Steve Rogers", "captainamerica@gmail.com", "password3")
        ));

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomer(int customer_id) {
        return customers.stream().filter(c -> c.getCustomer_id() == customer_id).findFirst().get();

    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void updateCustomer(Customer customer, int customer_id) {
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            if (c.getCustomer_id() == customer_id) {
                customers.set(i, customer);
                return;
            }
        }
    }

    public void deleteCustomer(int customer_id) {
        customers.removeIf(c -> c.getCustomer_id() == customer_id);
    }
}
