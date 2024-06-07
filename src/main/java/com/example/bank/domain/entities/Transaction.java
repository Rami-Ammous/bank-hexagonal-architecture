package com.example.bank.domain.entities;

import java.util.Date;

/**
 * @author Rami Ammous
 */

public abstract class Transaction {

    private Long id;

    private Double montant;

    private Date dateMvt;

    private Account compte;
}
