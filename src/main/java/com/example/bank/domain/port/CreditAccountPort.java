package com.example.bank.domain.port;

import com.example.bank.domain.entities.Transaction;

/**
 * @author Rami Ammous
 */
public interface CreditAccountPort {

    void save(Transaction transaction);
}
