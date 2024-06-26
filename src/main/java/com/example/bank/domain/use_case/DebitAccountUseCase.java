package com.example.bank.domain.use_case;

import com.example.bank.domain.exception.BadRequestException;
import com.example.bank.domain.exception.OperationFailedException;
import com.example.bank.domain.exception.RecordNotFoundException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.entities.Transaction;
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
        if (requestMvt == null || requestMvt.getIdAccount() == null || requestMvt.getAmount() == null)
            throw new BadRequestException(" Not valid input");

        Optional<Account> accountOptional = accountPort.findById(requestMvt.getIdAccount());
        if (!accountOptional.isPresent()) {
            throw new RecordNotFoundException("Account : " + requestMvt.getIdAccount() + " not found in database");
        }

        Account account = accountOptional.get();

        if (account.getSolde() < requestMvt.getAmount())
            throw new OperationFailedException("Unable to complete this operation : insufficient balance");

        Transaction transaction =
                new Transaction(null, requestMvt.getAmount(), null, account);

        account.setSolde(account.getSolde() - requestMvt.getAmount());

        debitAccountPort.save(transaction);

        return accountPort.update(account);
    }

}
