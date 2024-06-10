package com.example.bank.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Rami Ammous
 */
@Getter @AllArgsConstructor
public class RequestTransactionDto {

    @NotNull(message = "l'id compte ne doit pas étre non null")
    private Long idCompte;

    @NotNull(message = "doit étre non null")
    @Min(value = 5 , message = "le montant de la transaction doit etre superieur ou egal a 5 DT")
    private Double montant;

}
