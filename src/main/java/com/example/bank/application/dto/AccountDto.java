package com.example.bank.application.dto;

import com.example.bank.domain.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Rami Ammous
 */
@Getter
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private Double solde;
    private CustomerDto customer;


}
