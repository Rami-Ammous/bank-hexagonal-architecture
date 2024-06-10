package com.example.bank.application.controller;

import com.example.bank.application.Constants;
import com.example.bank.application.dto.AccountDto;
import com.example.bank.application.dto.RequestTransactionDto;
import com.example.bank.application.mapper.AccountMapperDto;
import com.example.bank.application.mapper.RequestMvtMapperDto;
import com.example.bank.domain.use_case.CreditAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Rami Ammous
 */
@RestController
@RequiredArgsConstructor
public class CreditAccountController {

    public final CreditAccountUseCase creditAccountUseCase;


    @PostMapping(Constants.CREDIT_COMPTE_ENDPOINT)
    @Transactional
    public ResponseEntity<AccountDto>  creditAccount(@Valid @RequestBody RequestTransactionDto requestMvtDto){
    return new ResponseEntity(AccountMapperDto.domainToDto(creditAccountUseCase.creditAccount(
            RequestMvtMapperDto.dtoToDomain(requestMvtDto))) ,
            HttpStatus.ACCEPTED);
    }
}
