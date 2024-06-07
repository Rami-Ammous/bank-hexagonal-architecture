package com.example.bank.infrastructure.database.repository;

import com.example.bank.infrastructure.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Rami Ammous
 */
@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long> {

    Optional<CustomerEntity> findByName(String name);

}
