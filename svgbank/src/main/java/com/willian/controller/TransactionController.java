package com.willian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willian.dto.TransferDto;
import com.willian.service.TransferService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {
    private TransferService transferService;
    
    @GetMapping
    public String test(){
        return "Transaction path";
    }

    @PostMapping
    public String transfer(@RequestBody TransferDto transferData){
        return transferService.execute(transferData);
    }
}
