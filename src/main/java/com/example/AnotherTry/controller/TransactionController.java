package com.example.AnotherTry.controller;

import com.example.AnotherTry.model.Transaction;
import com.example.AnotherTry.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "code/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Transaction>> getTransactionsByCode(@PathVariable("code") Long code) {
        List<Transaction> transactions = transactionService.getAllByCode(code);

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @RequestMapping(value = "contract/{contractNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Transaction> getTransactionsByContract(@PathVariable("contractNumber") Long contractNumber) {
        Transaction transaction = transactionService.getByContract(contractNumber);
        if (transaction == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAll();

        if (transactions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        if (transaction == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        transaction.setTime(LocalDateTime.now());
        transactionService.save(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction) {
        if (transaction == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        transaction.setTime(LocalDateTime.now());
        transactionService.save(transaction);

        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @RequestMapping(value = "contract/{contractNumber}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("contractNumber") Long contractNumber) {
        Transaction transaction = transactionService.getByContract(contractNumber);
        if (transaction == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        transactionService.delete(contractNumber);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
