package com.willian.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willian.dto.TransferDto;
import com.willian.model.Transaction;
import com.willian.repository.TransactionRepository;
import com.willian.repository.UserRepository;
import com.willian.service.GetTransactions;
import com.willian.service.TransferService;
import com.willian.utils.PasswordEncoder;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {
    private GetTransactions getTransactions;
    private TransactionRepository transactionRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{email}")
    public List<Transaction> getTransactions(@PathVariable("email") String email){
        return getTransactions.execute(email);
    }

    @PostMapping
    public String transfer(@RequestBody TransferDto transferData){
        TransferService transferService = new TransferService(userRepository, transactionRepository, passwordEncoder);
        return transferService.execute(transferData);
    }

}
