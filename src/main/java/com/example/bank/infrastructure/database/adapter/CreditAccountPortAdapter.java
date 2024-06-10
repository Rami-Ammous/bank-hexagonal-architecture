package com.example.bank.infrastructure.database.adapter;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.RequestMvt;
import com.example.bank.domain.port.CreditAccountPort;
import com.example.bank.infrastructure.database.entity.AccountEntity;
import com.example.bank.infrastructure.database.entity.CreditAccountEntity;
import com.example.bank.infrastructure.database.mapper.AccountMapper;
import com.example.bank.infrastructure.database.repository.CreditAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Rami Ammous
 */
@Service
@RequiredArgsConstructor
public class CreditAccountPortAdapter implements CreditAccountPort {

    public final AccountPortAdapter accountPortAdapter;
    public final CreditAccountRepo creditAccountRepo;

    @Override
    public Account creditAccount(RequestMvt requestMvt) {

        if( requestMvt == null || requestMvt.getIdCompte() == null || requestMvt.getMontant() == null)
            throw  new BadRequestException(" Not valid input");

        AccountEntity accountEntity = AccountMapper.domainToEntity(
                accountPortAdapter.findById(requestMvt.getIdCompte()
                ));

        CreditAccountEntity creditAccountEntity = new CreditAccountEntity(
                null, requestMvt.getMontant(), null, accountEntity
        );

        accountEntity.setSolde(accountEntity.getSolde() + requestMvt.getMontant());

        creditAccountRepo.save(creditAccountEntity);

        return accountPortAdapter.update(AccountMapper.entityToDomain(accountEntity));

    }
}
