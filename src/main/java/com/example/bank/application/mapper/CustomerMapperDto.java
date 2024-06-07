package com.example.bank.application.mapper;

import com.example.bank.application.dto.CustomerDto;
import com.example.bank.domain.entities.Customer;

/**
 * @author Rami Ammous
 */
public interface CustomerMapperDto {

    public static CustomerDto fromDomainToDto(Customer customer) {
        return new CustomerDto(customer.getId(),customer.getName());
    }

    public static Customer fromDtoToEntity(CustomerDto customerDto) {
        return new Customer(customerDto.getId(),customerDto.getName());
    }

}
