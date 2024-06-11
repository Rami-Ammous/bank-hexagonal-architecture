package com.example.bank.infrastructure.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Rami Ammous
 */
@Entity
@DiscriminatorValue("credit")
@Getter @Setter
public class CreditAccountEntity extends TransactionEntity {

    public CreditAccountEntity(Long id, Double amount, Date dateMvt, AccountEntity account) {
        super(id, amount, dateMvt, account);
    }
}
