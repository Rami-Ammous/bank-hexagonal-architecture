package com.example.bank.bootstrap;

import com.example.bank.domain.port.AccountPort;
import com.example.bank.domain.port.CreditAccountPort;
import com.example.bank.domain.port.CustomerPort;
import com.example.bank.domain.port.DebitAccountPort;
import com.example.bank.domain.use_case.AccountManagementUseCase;
import com.example.bank.domain.use_case.CreditAccountUseCase;
import com.example.bank.domain.use_case.CustomerManagementUseCase;
import com.example.bank.domain.use_case.DebitAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Rami Ammous
 */
@Configuration
@EnableJpaAuditing
public class DomainConfiguration {

    @Bean
    public CustomerManagementUseCase insertCustomerUseCase(CustomerPort consumerPort){
        return new CustomerManagementUseCase(consumerPort);
    }

    @Bean
    public AccountManagementUseCase accountManagementUseCase(AccountPort accountPort){
        return new AccountManagementUseCase(accountPort);
    }

    @Bean
    public CreditAccountUseCase creditAccountUseCase(CreditAccountPort creditAccountPort,  AccountPort accountPort){
        return new CreditAccountUseCase(creditAccountPort,accountPort);
    }

    @Bean
    public DebitAccountUseCase debitAccountUseCase(DebitAccountPort debitAccountPort, AccountPort accountPort){
        return new DebitAccountUseCase(debitAccountPort,accountPort);
    }
}
