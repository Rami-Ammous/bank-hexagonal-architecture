package com.example.bank.testendtoend;


import com.example.bank.application.Constants;
import com.example.bank.application.dto.AccountDto;
import com.example.bank.application.dto.RequestTransactionDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Rami Ammous
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditAccount {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void creditAccount() {

        String url =  "/"+ Constants.CREDIT_COMPTE_ENDPOINT;
        HttpEntity<RequestTransactionDto> request = new HttpEntity<>(new RequestTransactionDto(1L,200.0));
        ResponseEntity<AccountDto> result = testRestTemplate.postForEntity(url, request, AccountDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.ACCEPTED);
    }
}
