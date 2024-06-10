package com.example.bank.infrastructure.database.repository;

import com.example.bank.infrastructure.database.entity.DebitAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rami Ammous
 */
public interface DebitAccountRepo extends JpaRepository<DebitAccountEntity,Long> {
}
