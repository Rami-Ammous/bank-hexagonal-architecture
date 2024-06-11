package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public class CreditAccount extends Transaction {

    public CreditAccount(Long id, Double amount, Date dateMvt, Account account) {
        super(id, amount, dateMvt, account);
    }
}
