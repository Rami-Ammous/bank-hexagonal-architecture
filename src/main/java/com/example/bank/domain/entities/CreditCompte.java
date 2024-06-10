package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public class CreditCompte extends Transaction {

    public CreditCompte(Long id, Double montant, Date dateMvt, Account compte) {
        super(id, montant, dateMvt, compte);
    }
}
