package com.example.bank.domain.port;

import com.example.bank.domain.entities.Transaction;

/**
 * @author Rami Ammous
 */
public interface DebitAccountPort {
    void save(Transaction transaction);
}
