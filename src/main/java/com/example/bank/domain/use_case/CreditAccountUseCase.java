package com.example.bank.domain.use_case;

import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.RequestMvt;
import com.example.bank.domain.port.CreditAccountPort;

/**
 * @author Rami Ammous
 */

public class CreditAccountUseCase {

    private final CreditAccountPort creditAccountPort;

    public CreditAccountUseCase(CreditAccountPort creditAccountPort) {
        this.creditAccountPort = creditAccountPort;
    }

    public Account creditAccount(RequestMvt requestMvt){
        return creditAccountPort.creditAccount(requestMvt);
    }
}
