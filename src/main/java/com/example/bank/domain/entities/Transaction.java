package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public abstract class Transaction {

    public Transaction(Long id, Double amount, Date dateMvt, Account account) {
        this.id = id;
        this.amount = amount;
        this.dateMvt = dateMvt;
        this.account = account;
    }

    private Long id;

    private Double amount;

    private Date dateMvt;

    private Account account;

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDateMvt() {
        return dateMvt;
    }

    public Account getAccount() {
        return account;
    }
}
