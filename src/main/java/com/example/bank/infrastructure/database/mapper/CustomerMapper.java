package com.example.bank.infrastructure.database.mapper;

import com.example.bank.domain.entities.Customer;
import com.example.bank.infrastructure.database.entity.CustomerEntity;

/**
 * @author Rami Ammous
 */
public interface CustomerMapper {

    public static CustomerEntity toEntity(Customer customer) {

        if(customer == null) return null;

        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }

    public static Customer toDomain(CustomerEntity customerEntity) {

        if(customerEntity == null) return null;

        return new Customer(customerEntity.getId(),customerEntity.getName());

    }
}
