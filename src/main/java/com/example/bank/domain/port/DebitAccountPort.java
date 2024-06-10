package com.example.bank.domain.port;

import com.example.bank.domain.entities.DebitAccount;

/**
 * @author Rami Ammous
 */
public interface DebitAccountPort {
    void save(DebitAccount debitAccount);
}
