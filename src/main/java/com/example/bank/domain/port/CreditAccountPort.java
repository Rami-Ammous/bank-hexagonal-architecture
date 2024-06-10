package com.example.bank.domain.port;

import com.example.bank.domain.entities.CreditAccount;

/**
 * @author Rami Ammous
 */
public interface CreditAccountPort {

    void save(CreditAccount creditAccount);
}
