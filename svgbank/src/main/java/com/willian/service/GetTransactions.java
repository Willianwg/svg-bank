package com.willian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.model.Transaction;
import com.willian.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetTransactions {
    private TransactionRepository transactionRepository;

    public List<Transaction>execute(String user_email){
        List<Transaction> sentTransactions =  transactionRepository.findAll();

        return sentTransactions;
    }
}
