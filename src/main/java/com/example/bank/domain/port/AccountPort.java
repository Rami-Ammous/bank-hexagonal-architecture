package com.example.bank.domain.port;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author Rami Ammous
 */
public interface AccountPort {

    Account save(Account account);
    List<Account> saveAll(List<Account>  lstAccount);

    List<Account> getAll();

    Optional<Account>  findById(Long idAccount);

    Account update(Account account);
}
