package com.example.bank.infrastructure.database.adapter;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.domain.entities.CreditAccount;
import com.example.bank.domain.port.CreditAccountPort;
import com.example.bank.infrastructure.database.mapper.CreditAccountMapper;
import com.example.bank.infrastructure.database.repository.CreditAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Rami Ammous
 */
@Service
@RequiredArgsConstructor
public class CreditAccountPortAdapter implements CreditAccountPort {

    public final CreditAccountRepo creditAccountRepo;

    @Override
    public void save(CreditAccount creditAccount) {
        if(creditAccount == null) {throw new BadRequestException("");}
        else {
            creditAccountRepo.save(CreditAccountMapper.domainToEntity(creditAccount));
        }
    }
}

