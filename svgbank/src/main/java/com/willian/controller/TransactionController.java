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
import com.willian.service.GetTransactions;
import com.willian.service.TransferService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {
    private TransferService transferService;
    private GetTransactions getTransactions;

    @GetMapping("/{email}")
    public List<Transaction> getTransactions(@PathVariable("email") String email){
        return getTransactions.execute(email);
    }

    @PostMapping
    public String transfer(@RequestBody TransferDto transferData){
        return transferService.execute(transferData);
    }

}
