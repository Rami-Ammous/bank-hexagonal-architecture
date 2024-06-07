/*
package com.example.bank.domain.use_case;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.domain.entities.Compte;
import com.example.bank.domain.entities.RequestMvt;

*/
/**
 * @author Rami Ammous
 *//*

public class CreditAccountUseCase {

    public final


    public Compte creditAccount(RequestMvt requestMvt) {

        if( requestMvt == null || requestMvt.getIdCompte() == null || requestMvt.getMontant() == null)
            throw  new BadRequestException("entrée non valide");

        Compte compte = compteService.findById(requestMvt.getIdCompte());

        CreditCompteDto creditCompteDto = CreditCompteDto.builder()
                .montant(requestMvtDto.getMontant())
                .compte(compteDto)
                .build();

        compteDto.setSolde(compteDto.getSolde()+requestMvt.getMontant());

        creditCompteRepo.save(CreditCompteMapper.toEntity(creditCompteDto));

        return compteService.update(compteDto);

    }
}
*/
