package com.example.bank.infrastructure.database.adapter;

import com.example.bank.domain.exception.BadRequestException;
import com.example.bank.domain.entities.Transaction;
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
    public void save(Transaction transaction) {
        if(transaction == null) {throw new BadRequestException("");}
        else {
            creditAccountRepo.save(CreditAccountMapper.domainToEntity(transaction));
        }
    }
}

