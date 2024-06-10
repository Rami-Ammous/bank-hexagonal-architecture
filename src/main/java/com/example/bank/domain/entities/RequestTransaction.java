package com.example.bank.domain.entities;

/**
 * @author Rami Ammous
 */
public class RequestTransaction {

    private Long idAccount;
    private Double montant;


    public RequestTransaction(Long idAccount, Double montant) {
        this.idAccount = idAccount;
        this.montant = montant;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public Double getMontant() {
        return montant;
    }
}
