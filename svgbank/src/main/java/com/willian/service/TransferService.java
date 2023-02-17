package com.willian.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.willian.dto.TransferDto;
import com.willian.model.Transaction;
import com.willian.model.User;
import com.willian.repository.TransactionRepository;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    public String execute(TransferDto transferData) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        User from = userRepository.findById(transferData.getFrom()).get();
        User to = userRepository.findById(transferData.getTo()).get();

        String encodedPassword = from.getPassword();
        boolean match = bcrypt.matches(transferData.getPassword(), encodedPassword);

        if (!match) {
            return "Fail to resolve transaction, wrong credentials";
        }

        double amount = transferData.getAmount();

        boolean success = from.debit(amount);

        if (!success) {
            return "Fail to resolve transaction, insufficient balance";
        }

        to.credit(amount);

        Transaction transaction = new Transaction();
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);
                
        userRepository.save(from);
        userRepository.save(to);

        return "Transaction succeeded";

    }
}
