package com.example.bank.bootstrap;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.use_case.AccountManagementUseCase;
import com.example.bank.domain.use_case.CreditAccountUseCase;
import com.example.bank.domain.use_case.CustomerManagementUseCase;
import com.example.bank.domain.use_case.DebitAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Rami Ammous
 */

@Component
public class StarUp implements CommandLineRunner {

    @Autowired
    CustomerManagementUseCase customerManagementUseCase;

    @Autowired
    AccountManagementUseCase accountManagementUseCase;

    @Autowired
    CreditAccountUseCase creditAccountUseCase;

    @Autowired
    DebitAccountUseCase debitAccountUseCase;


/*
    @Autowired
    DebitCompteService debitCompteService;

    @Autowired
    CreditCompteService creditCompteService;*/

    @Override
    public void run(String... args) throws Exception {

if(customerManagementUseCase.getAll().isEmpty())
    { customerManagementUseCase.insertLst(Arrays.asList(
            new Customer(null,"Rami Ammous"),
            new Customer(null,"Bilel Loussaief")

            )); }

if(accountManagementUseCase.getAll().isEmpty())
{
    accountManagementUseCase.insertLst(Arrays.asList(
            new Account(1L,new Double(10000.0),customerManagementUseCase.findByName("Rami Ammous")),
            new Account(2L,new Double(50000.0),customerManagementUseCase.findByName("Bilel Loussaief"))

            ));

}



       /* System.err.println(
                creditAccountUseCase.creditAccount(
                        new RequestMvt(1L,new Double(50))
                ));*/

        /*System.err.println(
                debitAccountUseCase.debitAccount(
                        new RequestMvt(1L,new Double(100))
                ));*/




    }






}
