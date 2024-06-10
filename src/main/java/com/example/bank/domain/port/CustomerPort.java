package com.example.bank.domain.port;

import com.example.bank.domain.entities.Customer;

import java.util.List;

/**
 * @author Rami Ammous
 */
public interface CustomerPort {

    Customer save(Customer customer);
    List<Customer> saveAll(List<Customer>  lstCustomer);

    List<Customer> getAll();
    Customer findByName(String name);
}
