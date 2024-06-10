package com.example.bank.infrastructure.database.adapter;

import com.example.bank.core.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.port.CustomerPort;
import com.example.bank.infrastructure.database.mapper.CustomerMapper;
import com.example.bank.infrastructure.database.repository.CustomerRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll().stream().map(CustomerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer>  saveAll(List<Customer> lstCustomer) {
        return customerRepo.saveAll(
                lstCustomer.stream().map(CustomerMapper::toEntity).collect(Collectors.toList())
        ).stream().map(CustomerMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Customer findByName(String name) {
        return customerRepo.findByName(name).map(CustomerMapper::toDomain)
                .orElseThrow( () -> new RecordNotFoundException("Customer " +name+ "not found in database"));
    }
}
