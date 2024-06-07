package com.example.bank.domain.port;

import com.example.bank.domain.entities.Customer;

/**
 * @author Rami Ammous
 */
public interface CustomerPort {

    Customer save(Customer customer);

}
