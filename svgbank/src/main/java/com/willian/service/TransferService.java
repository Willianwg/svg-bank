package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.dto.TransferDto;
import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
    private UserRepository userRepository;

    public String execute(TransferDto transferData){
        User from = userRepository.findById(transferData.getFrom()).get();
        User to = userRepository.findById(transferData.getTo()).get();
        double amount = transferData.getAmount();

        boolean success = from.debit(amount);

        if(success){
            to.credit(amount);
            userRepository.save(from);
            userRepository.save(to);
            return "Transaction succeeded";
        }

        return "Fail to resolve transaction";
        

    }
}
