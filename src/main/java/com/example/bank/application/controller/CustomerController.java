package com.example.bank.application.controller;

import com.example.bank.application.dto.CustomerDto;
import com.example.bank.application.mapper.CustomerMapperDto;
import com.example.bank.domain.use_case.InsertCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rami Ammous
 */
@RestController
@RequestMapping("")
public class CustomerController {

    public final InsertCustomerUseCase insertCustomerUseCase;


    public CustomerController(InsertCustomerUseCase insertCustomerUseCase) {
        this.insertCustomerUseCase = insertCustomerUseCase;
    }

    @PostMapping("api/v1/customer")
    public ResponseEntity<CustomerDto> insert(@RequestBody CustomerDto customerDto){
        return new ResponseEntity(insertCustomerUseCase.insert(CustomerMapperDto.fromDtoToEntity(customerDto)) , HttpStatus.OK);
    }

}
