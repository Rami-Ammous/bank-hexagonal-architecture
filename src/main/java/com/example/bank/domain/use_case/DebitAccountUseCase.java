package com.example.bank.domain.use_case;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.core.exception.OperationFailedException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.DebitAccount;
import com.example.bank.domain.entities.RequestMvt;
import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.DebitAccountPort;
import lombok.RequiredArgsConstructor;

/**
 * @author Rami Ammous
 */
@RequiredArgsConstructor
public class DebitAccountUseCase {

    public final DebitAccountPort debitComptePort;
    public final AccountPort accountPort;

    public Account  debitAccount(RequestMvt requestMvt){
        if( requestMvt == null || requestMvt.getIdCompte() == null || requestMvt.getMontant() == null)
            throw  new BadRequestException(" Not valid input");

        Account account = accountPort.findById(requestMvt.getIdCompte());

        if(account.getSolde() < requestMvt.getMontant()) throw new OperationFailedException("Unable to complete this operation : insufficient balance");

        DebitAccount debitAccount =
                new DebitAccount(null,requestMvt.getMontant(),null,account);

        account.setSolde(account.getSolde() - requestMvt.getMontant());

        debitComptePort.save(debitAccount);
        int x =1/0;
        return accountPort.update(account);
    }

}
