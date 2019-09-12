package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction getByContractNumber(Long contractNumber);

    void save(Transaction transaction);

    void delete(Long contractNumber); // по контр намберу?

    List<Transaction> getAll();

}
