package com.example.bank.application;

/**
 * @author Rami Ammous
 */
public interface Constants {

    String APP_ROOT                     = "api/v1";

    String MOUVEMENT_ENDPOINT           = APP_ROOT + "/mvt" ;
    String CREDIT_COMPTE_ENDPOINT       = MOUVEMENT_ENDPOINT + "/credit";
    String DEBIT_COMPTE_ENDPOINT        = MOUVEMENT_ENDPOINT + "/debit";


}
