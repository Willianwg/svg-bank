package com.willian.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willian.model.Transaction;

@Service
public class TransactionRepository implements ITransactionRepository {
    @Autowired
    private TransactionRepositoryJPA transactionRepositoryJPA;

    @Override
    public Transaction save(Transaction transaction) {
       return this.transactionRepositoryJPA.save(transaction);
    }
    
}
