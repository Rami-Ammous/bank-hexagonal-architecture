package com.example.bank.infrastructure.database.mapper;

import com.example.bank.domain.entities.Transaction;
import com.example.bank.infrastructure.database.entity.CreditAccountEntity;

/**
 * @author Rami Ammous
 */
public interface CreditAccountMapper {

    public static Transaction entityToDomain(CreditAccountEntity creditAccountEntity){
        if (creditAccountEntity == null) return null;

        return new Transaction(
                creditAccountEntity.getId(),
                creditAccountEntity.getAmount(),
                creditAccountEntity.getDateMvt(),
                AccountMapper.entityToDomain( creditAccountEntity.getAccount())
        );
    }


    public static CreditAccountEntity domainToEntity(Transaction transaction){
        if (transaction == null) return null;

        return new CreditAccountEntity(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDateMvt(),
                AccountMapper.domainToEntity( transaction.getAccount())
        );
    }
}
