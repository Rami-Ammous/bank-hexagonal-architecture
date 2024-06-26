package com.example.bank.infrastructure.database.mapper;

import com.example.bank.domain.entities.Transaction;
import com.example.bank.infrastructure.database.entity.DebitAccountEntity;

/**
 * @author Rami Ammous
 */
public interface DebitAccountMapper {

    public static Transaction entityToDomain(DebitAccountEntity debitAccountEntity){
        if (debitAccountEntity == null) return null;

        return new Transaction(
                debitAccountEntity.getId(),
                debitAccountEntity.getAmount(),
                debitAccountEntity.getDateMvt(),
                AccountMapper.entityToDomain( debitAccountEntity.getAccount())
        );
    }


    public static DebitAccountEntity domainToEntity(Transaction transaction){
        if (transaction == null) return null;

        return new DebitAccountEntity(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getDateMvt(),
                AccountMapper.domainToEntity( transaction.getAccount())
        );
    }
}
