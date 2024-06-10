package com.example.bank.domain.use_case;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.core.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.CreditAccount;
import com.example.bank.domain.entities.RequestTransaction;
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

        if( requestMvt == null || requestMvt.getIdAccount() == null || requestMvt.getMontant() == null)
            throw  new BadRequestException(" Not valid input");

        Optional<Account> accountOptional = accountPort.findById(requestMvt.getIdAccount());
        if (!accountOptional.isPresent()) {
            throw new RecordNotFoundException("Account : " + requestMvt.getIdAccount() + " not found in database");
        }

        Account account = accountOptional.get();
        CreditAccount creditAccount =
                new CreditAccount(null,requestMvt.getMontant(),null,account);

        account.setSolde(account.getSolde() + requestMvt.getMontant());
        creditAccountPort.save(creditAccount);

        return accountPort.update(account);
    }
}
