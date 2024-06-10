package com.example.bank.domain.use_case;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.port.AccountPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Rami Ammous
 */
@RequiredArgsConstructor
public class AccountManagementUseCase {

    private final AccountPort accountPort;

    public Account insertAccount(Account account) {
        return accountPort.save(account);
    }

    public List<Account> insertLst(List<Account> lstAccount) {
        return accountPort.saveAll(lstAccount);
    }


    public List<Account> getAll() {
        return accountPort.getAll();
    }



}
