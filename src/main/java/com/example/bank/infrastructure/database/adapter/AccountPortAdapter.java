package com.example.bank.infrastructure.database.adapter;

import com.example.bank.domain.exception.BadRequestException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.infrastructure.database.mapper.AccountMapper;
import com.example.bank.infrastructure.database.repository.AccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Rami Ammous
 */
@Component
@RequiredArgsConstructor
public class AccountPortAdapter implements AccountPort {

    private final AccountRepo accountRepo;

    @Override
    public Account save(Account account) {

        return AccountMapper.entityToDomain(accountRepo.save(AccountMapper.domainToEntity(account)));
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll().stream().map(AccountMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Account> saveAll(List<Account> lstAccount) {
        return accountRepo.saveAll(
                lstAccount.stream().map(AccountMapper::domainToEntity).collect(Collectors.toList())
        ).stream().map(AccountMapper::entityToDomain).collect(Collectors.toList());
    }

    public Optional<Account> findById(Long id){
        if(id == null) throw  new BadRequestException("id is Null");

        return accountRepo.findById(id).map(AccountMapper::entityToDomain);
    }

    public Account update(Account account) {

        if(account == null || account.getId() == null ) throw  new BadRequestException("invalid input");

        findById(account.getId());

        return AccountMapper.entityToDomain(
                accountRepo.save(AccountMapper.domainToEntity( account))
        );
    }


}
