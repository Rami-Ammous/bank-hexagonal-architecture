package com.example.bank.domain.entities;

/**
 * @author Rami Ammous
 */
public class RequestMvt {

    private Long idCompte;
    private Double montant;


    public RequestMvt(Long idCompte, Double montant) {
        this.idCompte = idCompte;
        this.montant = montant;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public Double getMontant() {
        return montant;
    }
}
