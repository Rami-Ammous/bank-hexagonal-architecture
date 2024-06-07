package com.example.bank.infrastructure.database.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Rami Ammous
 */
@Entity
@DiscriminatorValue("debit")
public class DebitAccount extends Transaction {

    public DebitAccount(Long id, Double montant, Date dateMvt, Account compte) {
        super(id, montant, dateMvt, compte);
    }


}
