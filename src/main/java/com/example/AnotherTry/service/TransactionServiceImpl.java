package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Transaction;
import com.example.AnotherTry.repo.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Transaction getByCode(Long code) {
        return transactionRepo.getOne(code);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public void delete(Long code) {
        transactionRepo.deleteById(code);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }

    @Override
    public List<Transaction> getAllByCode(Long code) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction t : transactionRepo.findAll())
            if (t.getCode().equals(code)) transactions.add(t);

        return transactions;
    }
}
