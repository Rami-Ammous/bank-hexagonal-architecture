package com.example.bank.infrastructure.database.mapper;

import com.example.bank.domain.entities.DebitAccount;
import com.example.bank.infrastructure.database.entity.DebitAccountEntity;

/**
 * @author Rami Ammous
 */
public interface DebitAccountMapper {

    public static DebitAccount entityToDomain(DebitAccountEntity debitAccountEntity){
        if (debitAccountEntity == null) return null;

        return new DebitAccount(
                debitAccountEntity.getId(),
                debitAccountEntity.getMontant(),
                debitAccountEntity.getDateMvt(),
                AccountMapper.entityToDomain( debitAccountEntity.getAccount())
        );
    }


    public static DebitAccountEntity domainToEntity(DebitAccount debitAccount){
        if (debitAccount == null) return null;

        return new DebitAccountEntity(
                debitAccount.getId(),
                debitAccount.getMontant(),
                debitAccount.getDateMvt(),
                AccountMapper.domainToEntity( debitAccount.getAccount())
        );
    }
}
