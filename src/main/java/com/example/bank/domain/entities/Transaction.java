package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public abstract class Transaction {

    public Transaction(Long id, Double montant, Date dateMvt, Account account) {
        this.id = id;
        this.montant = montant;
        this.dateMvt = dateMvt;
        this.account = account;
    }

    private Long id;

    private Double montant;

    private Date dateMvt;

    private Account account;

    public Long getId() {
        return id;
    }

    public Double getMontant() {
        return montant;
    }

    public Date getDateMvt() {
        return dateMvt;
    }

    public Account getAccount() {
        return account;
    }
}
