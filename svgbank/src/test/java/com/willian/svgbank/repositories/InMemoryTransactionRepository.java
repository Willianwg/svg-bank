package com.willian.svgbank.repositories;

import java.util.ArrayList;
import java.util.List;

import com.willian.model.Transaction;
import com.willian.repository.ITransactionRepository;

public class InMemoryTransactionRepository implements ITransactionRepository {
    private List<Transaction> transactions;

    public InMemoryTransactionRepository(){
        this.transactions = new ArrayList<>();
    }

    @Override
    public Transaction save(Transaction transaction) {
       this.transactions.add(transaction);

       return transaction;
    }
    
}
