package com.example.bank.infrastructure.database.adapter;

import com.example.bank.core.exception.BadRequestException;
import com.example.bank.domain.entities.DebitAccount;
import com.example.bank.domain.port.DebitAccountPort;
import com.example.bank.infrastructure.database.mapper.AccountMapper;
import com.example.bank.infrastructure.database.mapper.DebitAccountMapper;
import com.example.bank.infrastructure.database.repository.DebitAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Rami Ammous
 */
@RequiredArgsConstructor
@Component
public class DebitAccountPortAdapter implements DebitAccountPort {

    public final DebitAccountRepo debitAccountRepo;

    @Override
    public void save(DebitAccount debitAccount) {
        if(debitAccount == null) {throw new BadRequestException("");}
        else {
            debitAccountRepo.save(DebitAccountMapper.domainToEntity(debitAccount));
        }
        }
    }

