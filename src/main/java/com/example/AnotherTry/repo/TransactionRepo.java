package com.example.AnotherTry.repo;

import com.example.AnotherTry.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
