package com.example.bank.domain.use_case;

import com.example.bank.domain.exception.BadRequestException;
import com.example.bank.domain.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.entities.Transaction;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.CreditAccountPort;

import java.util.Optional;

/**
 * @author Rami Ammous
 */

public class CreditAccountUseCase {

    private final CreditAccountPort creditAccountPort;
    private final AccountPort accountPort;

    public CreditAccountUseCase(CreditAccountPort creditAccountPort, AccountPort accountPort) {
        this.creditAccountPort = creditAccountPort;
        this.accountPort = accountPort;
    }

    public Account creditAccount(RequestTransaction requestMvt){

        if( requestMvt == null || requestMvt.getIdAccount() == null || requestMvt.getAmount() == null)
            throw  new BadRequestException(" Not valid input");

        Optional<Account> accountOptional = accountPort.findById(requestMvt.getIdAccount());
        if (!accountOptional.isPresent()) {
            throw new RecordNotFoundException("Account : " + requestMvt.getIdAccount() + " not found in database");
        }

        Account account = accountOptional.get();
        Transaction transaction =
                new Transaction(null,requestMvt.getAmount(),null,account);

        account.setSolde(account.getSolde() + requestMvt.getAmount());
        creditAccountPort.save(transaction);

        return accountPort.update(account);
    }
}
