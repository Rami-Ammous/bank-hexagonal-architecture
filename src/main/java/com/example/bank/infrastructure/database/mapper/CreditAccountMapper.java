package com.example.bank.infrastructure.database.mapper;

import com.example.bank.domain.entities.CreditAccount;
import com.example.bank.infrastructure.database.entity.CreditAccountEntity;

/**
 * @author Rami Ammous
 */
public interface CreditAccountMapper {

    public static CreditAccount entityToDomain(CreditAccountEntity creditAccountEntity){
        if (creditAccountEntity == null) return null;

        return new CreditAccount(
                creditAccountEntity.getId(),
                creditAccountEntity.getMontant(),
                creditAccountEntity.getDateMvt(),
                AccountMapper.entityToDomain( creditAccountEntity.getAccount())
        );
    }


    public static CreditAccountEntity domainToEntity(CreditAccount creditAccount){
        if (creditAccount == null) return null;

        return new CreditAccountEntity(
                creditAccount.getId(),
                creditAccount.getMontant(),
                creditAccount.getDateMvt(),
                AccountMapper.domainToEntity( creditAccount.getAccount())
        );
    }
}
