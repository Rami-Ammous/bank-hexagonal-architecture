package com.example.bank.application.controller;

import com.example.bank.application.Constants;
import com.example.bank.application.dto.AccountDto;
import com.example.bank.application.mapper.AccountMapperDto;
import com.example.bank.domain.entities.RequestMvt;
import com.example.bank.domain.use_case.DebitAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rami Ammous
 */
@RestController
@RequiredArgsConstructor
public class DebitAccountContrommer {

public final DebitAccountUseCase debitAccountUseCase;

    @PostMapping(Constants.DEBIT_COMPTE_ENDPOINT)
    @Transactional
    public ResponseEntity<AccountDto> debitAccount(@RequestBody RequestMvt requestMvt){
        return new ResponseEntity(AccountMapperDto.domainToDto(debitAccountUseCase.debitAccount(requestMvt)) , HttpStatus.ACCEPTED);

    }
}
