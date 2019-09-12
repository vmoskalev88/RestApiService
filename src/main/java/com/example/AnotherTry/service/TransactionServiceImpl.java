package com.example.AnotherTry.service;

import com.example.AnotherTry.model.Transaction;
import com.example.AnotherTry.repo.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

//todo сюда логирование добавить
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionServiceImpl(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public Transaction getByContractNumber(Long contractNumber) {
        return transactionRepo.getOne(contractNumber);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public void delete(Long contractNumber) {
        transactionRepo.deleteById((long) contractNumber);
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepo.findAll();
    }
}
