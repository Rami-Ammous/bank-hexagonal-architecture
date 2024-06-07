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
public class CreditAccount extends Transaction {

    public CreditAccount(Long id, Double montant, Date dateMvt, Account compte) {
        super(id, montant, dateMvt, compte);
    }
}
