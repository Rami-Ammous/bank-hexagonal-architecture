package com.example.bank.domain.entities;

/**
 * @author Rami Ammous
 */
public class RequestTransaction {

    private Long idAccount;
    private Double amount;


    public RequestTransaction(Long idAccount, Double amount) {
        this.idAccount = idAccount;
        this.amount = amount;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public Double getAmount() {
        return amount;
    }
}
