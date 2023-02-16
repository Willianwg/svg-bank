package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
    private UserRepository userRepository;

    public void execute(Long id){
        User user = userRepository.findById(id).get();

        double balance = user.getBalance();

        user.setBalance(balance + 10);

        userRepository.save(user);

    }
}
