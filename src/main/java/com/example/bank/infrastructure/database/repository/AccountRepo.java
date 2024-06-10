package com.example.bank.infrastructure.database.repository;

import com.example.bank.domain.entities.Account;
import com.example.bank.infrastructure.database.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rami Ammous
 */
public interface AccountRepo extends JpaRepository<AccountEntity,Long> {
}
