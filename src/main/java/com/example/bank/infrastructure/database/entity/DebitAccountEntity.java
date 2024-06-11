package com.example.bank.infrastructure.database.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Rami Ammous
 */
@Entity
@DiscriminatorValue("debit")
public class DebitAccountEntity extends TransactionEntity {

    public DebitAccountEntity(Long id, Double amount, Date dateMvt, AccountEntity account) {
        super(id, amount, dateMvt, account);
    }


}
