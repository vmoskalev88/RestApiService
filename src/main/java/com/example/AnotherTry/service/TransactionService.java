package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getByContract(Long contractNumber);

    void save(Transaction transaction);

    void delete(Long code);

    List<Transaction> getAll();

    List<Transaction> getAllByCode(Long code);
}
