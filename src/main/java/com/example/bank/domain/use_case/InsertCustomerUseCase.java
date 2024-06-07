package com.example.bank.domain.use_case;

import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.port.CustomerPort;

/**
 * @author Rami Ammous
 */
public class InsertCustomerUseCase {

    public final CustomerPort consumerPort;

    public InsertCustomerUseCase(CustomerPort consumerPort) {
        this.consumerPort = consumerPort;
    }

    public Customer insert(Customer customer) {
        return  consumerPort.save(customer);
    }
}
