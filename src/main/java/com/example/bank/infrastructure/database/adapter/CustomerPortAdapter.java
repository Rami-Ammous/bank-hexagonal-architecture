package com.example.bank.infrastructure.database.adapter;

import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.port.CustomerPort;
import com.example.bank.infrastructure.database.mapper.CustomerMapper;
import com.example.bank.infrastructure.database.repository.CustomerRepo;
import org.springframework.stereotype.Component;

/**
 * @author Rami Ammous
 */
@Component
public class CustomerPortAdapter implements CustomerPort {

    private final CustomerRepo customerRepo;

    public CustomerPortAdapter(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        return CustomerMapper.toDomain(customerRepo.save(CustomerMapper.toEntity(customer)));
    }
}
