package com.example.bank.application.mapper;


import com.example.bank.application.dto.RequestTransactionDto;
import com.example.bank.domain.entities.RequestTransaction;

/**
 * @author Rami Ammous
 */
public interface RequestMvtMapperDto {

    public static RequestTransaction dtoToDomain(RequestTransactionDto requestMvtDto){
        if (requestMvtDto == null) {return null;}

        return new RequestTransaction(
                requestMvtDto.getIdCompte(),
                requestMvtDto.getMontant()
        );
    }


    public static RequestTransactionDto domainToDto(RequestTransaction requestMvt){
        if (requestMvt == null) {return null;}

        return new RequestTransactionDto(
                requestMvt.getIdAccount(),
                requestMvt.getMontant()
        );
    }
}
