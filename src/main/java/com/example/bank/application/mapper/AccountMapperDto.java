package com.example.bank.application.mapper;

import com.example.bank.application.dto.AccountDto;
import com.example.bank.domain.entities.Account;

/**
 * @author Rami Ammous
 */
public interface AccountMapperDto {

    public static Account dtoToDomain(AccountDto accountDto){
        if (accountDto == null) {return null;}

        return new  Account(
                accountDto.getId(),
                accountDto.getSolde(),
                CustomerMapperDto.dtoToEntity( accountDto.getCustomer())
        );
    }


    public static AccountDto domainToDto(Account account){
        if (account == null) {return null;}

        return new  AccountDto(
                account.getId(),
                account.getSolde(),
                CustomerMapperDto.domainToDto( account.getCustomer())
        );
    }
}
