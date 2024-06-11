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

    @NotNull(message = "id account is null")
    private Long idCompte;

    @NotNull(message = "")
    @Min(value = 5 , message = "le amount de la transaction doit etre superieur ou egal a 5 DT")
    private Double amount;

}
