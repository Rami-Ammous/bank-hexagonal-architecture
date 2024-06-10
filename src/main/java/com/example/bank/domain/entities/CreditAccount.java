package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public class CreditAccount extends Transaction {

    public CreditAccount(Long id, Double montant, Date dateMvt, Account account) {
        super(id, montant, dateMvt, account);
    }
}
