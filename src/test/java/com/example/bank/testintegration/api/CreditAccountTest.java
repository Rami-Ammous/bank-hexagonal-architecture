package com.example.bank.testintegration.api;

import com.example.bank.application.Constants;
import com.example.bank.application.dto.RequestTransactionDto;
import com.example.bank.domain.entities.Account;
import com.example.bank.domain.entities.Customer;
import com.example.bank.domain.entities.RequestTransaction;
import com.example.bank.domain.use_case.CreditAccountUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Rami Ammous
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreditAccountTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private CreditAccountUseCase creditAccountUseCase;


    @BeforeAll
    public  void initMethod() {
        log.info("==== >> init method");

        Customer customer = new Customer(1L , "Rami");
        Account account = new Account(1L ,100.0,customer);

        Mockito.when(creditAccountUseCase.creditAccount(Mockito.any())).thenReturn(account);
    }


    @Test
    public void creditCompteApiTestOk() throws Exception {


            mockMvc.perform(MockMvcRequestBuilders.post("/"+ Constants.CREDIT_COMPTE_ENDPOINT)
                            .contentType("application/json")
                            .content(objectMapper.writeValueAsString(
                                    new RequestTransactionDto(1L, 100.0)
                            ))
                    )

                    .andExpect(status().isAccepted());
    }

    @Test
    public void creditCompteApiTestBadRequestIdCompteNull() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("/"+Constants.CREDIT_COMPTE_ENDPOINT)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(
                                new RequestTransaction(null, 100.0)
                        ))
                )

                .andExpect(status().isBadRequest());
    }

    @Test
    public void creditCompteApiTestBadRequestMontantNull() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.post("/"+Constants.CREDIT_COMPTE_ENDPOINT)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(
                                new RequestTransaction(1L, null)
                        ))
                )

                .andExpect(status().isBadRequest());
    }

}
