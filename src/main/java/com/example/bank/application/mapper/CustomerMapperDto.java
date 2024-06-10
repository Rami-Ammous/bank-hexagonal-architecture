package com.example.bank.application.mapper;

import com.example.bank.application.dto.CustomerDto;
import com.example.bank.domain.entities.Customer;

/**
 * @author Rami Ammous
 */
public interface CustomerMapperDto {

    public static CustomerDto domainToDto(Customer customer) {
        return new CustomerDto(customer.getId(),customer.getName());
    }

    public static Customer dtoToEntity(CustomerDto customerDto) {
        return new Customer(customerDto.getId(),customerDto.getName());
    }

}
