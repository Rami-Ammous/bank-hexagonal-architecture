package com.example.bank.application.controller;

import com.example.bank.application.dto.CustomerDto;
import com.example.bank.application.mapper.CustomerMapperDto;
import com.example.bank.domain.use_case.CustomerManagementUseCase;
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

    public final CustomerManagementUseCase customerManagementUseCase;


    public CustomerController(CustomerManagementUseCase customerManagementUseCase) {
        this.customerManagementUseCase = customerManagementUseCase;
    }

    @PostMapping("api/v1/customer")
    public ResponseEntity<CustomerDto> insert(@RequestBody CustomerDto customerDto){
        return new ResponseEntity(customerManagementUseCase.insert(CustomerMapperDto.dtoToEntity(customerDto)) , HttpStatus.OK);
    }

}
