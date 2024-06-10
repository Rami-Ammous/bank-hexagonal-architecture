package com.example.bank.infrastructure.database.mapper;


import com.example.bank.domain.entities.Account;
import com.example.bank.infrastructure.database.entity.AccountEntity;

/**
 * @author Rami Ammous
 */
public interface AccountMapper {



        public static AccountEntity domainToEntity(Account account) {

        if(account == null) return null;

        return AccountEntity.builder()
                .id(account.getId())
                .solde(account.getSolde())
                .customer(CustomerMapper.toEntity(account.getCustomer()))
                .build();
    }

        public static Account entityToDomain(AccountEntity accountEntity) {

        if(accountEntity == null) return null;

        return new Account(accountEntity.getId(),
                accountEntity.getSolde(),
                CustomerMapper.toDomain( accountEntity.getCustomer())

        );

    }

}
