package com.example.bank.domain.port;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.RequestMvt;

/**
 * @author Rami Ammous
 */
public interface CreditAccountPort {

    Account creditAccount(RequestMvt requestMvt);
}
