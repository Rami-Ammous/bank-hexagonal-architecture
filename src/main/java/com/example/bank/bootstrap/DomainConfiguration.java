package com.example.bank.bootstrap;

import com.example.bank.domain.port.CustomerPort;
import com.example.bank.domain.use_case.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rami Ammous
 */
@Configuration
public class DomainConfiguration {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(CustomerPort consumerPort){
        return new InsertCustomerUseCase(consumerPort);
    }
}
