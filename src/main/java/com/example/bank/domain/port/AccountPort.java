package com.example.bank.domain.port;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;

import java.util.List;

/**
 * @author Rami Ammous
 */
public interface AccountPort {

    Account save(Account account);
    List<Account> saveAll(List<Account>  lstAccount);

    List<Account> getAll();

    Account findById(Long idCompte);

    Account update(Account account);
}
