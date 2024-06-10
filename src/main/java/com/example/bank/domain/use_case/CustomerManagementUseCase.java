package com.example.bank.domain.use_case;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.port.CustomerPort;

import java.util.List;

/**
 * @author Rami Ammous
 */
public class CustomerManagementUseCase {

    public final CustomerPort consumerPort;

    public CustomerManagementUseCase(CustomerPort consumerPort) {
        this.consumerPort = consumerPort;
    }

    public Customer insert(Customer customer) {
        return consumerPort.save(customer);
    }
    public List<Customer> insertLst(List<Customer> lstCustomer) {
        return consumerPort.saveAll(lstCustomer);
    }


    public List<Customer> getAll() {
        return consumerPort.getAll();
    }

    public Customer findByName(String name){
        return consumerPort.findByName(name);
    }
}
