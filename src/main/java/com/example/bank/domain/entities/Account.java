package com.example.bank.domain.entities;

/**
 * @author Rami Ammous
 */

public class Account {

    private Long id;
    private Double solde;
    private Customer customer;

    public Account(Long id, Double solde, Customer customer) {
        this.id = id;
        this.solde = solde;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Double getSolde() {
        return solde;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
