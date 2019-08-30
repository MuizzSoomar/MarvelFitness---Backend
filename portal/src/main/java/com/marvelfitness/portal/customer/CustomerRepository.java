package com.marvelfitness.portal.customer;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findCustomersByName(String name);

    List<Customer> findCustomersByEmail(String email);
}
