package com.example.bank.infrastructure.database.repository;

import com.example.bank.infrastructure.database.entity.CreditAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rami Ammous
 */
public interface CreditAccountRepo extends JpaRepository<CreditAccountEntity,Long> {
}
