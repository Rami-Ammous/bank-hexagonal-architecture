package com.example.bank.domain.use_case;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.core.exception.OperationFailedException;
import com.example.bank.core.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.DebitAccount;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.DebitAccountPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * @author Rami Ammous
 */
@RequiredArgsConstructor
public class DebitAccountUseCase {

    private final DebitAccountPort debitAccountPort;
    private final AccountPort accountPort;

    public Account debitAccount(RequestTransaction requestMvt) {
        if (requestMvt == null || requestMvt.getIdAccount() == null || requestMvt.getMontant() == null)
            throw new BadRequestException(" Not valid input");

        Optional<Account> accountOptional = accountPort.findById(requestMvt.getIdAccount());
        if (!accountOptional.isPresent()) {
            throw new RecordNotFoundException("Account : " + requestMvt.getIdAccount() + " not found in database");
        }

        Account account = accountOptional.get();

        if (account.getSolde() < requestMvt.getMontant())
            throw new OperationFailedException("Unable to complete this operation : insufficient balance");

        DebitAccount debitAccount =
                new DebitAccount(null, requestMvt.getMontant(), null, account);

        account.setSolde(account.getSolde() - requestMvt.getMontant());

        debitAccountPort.save(debitAccount);

        return accountPort.update(account);
    }

}
