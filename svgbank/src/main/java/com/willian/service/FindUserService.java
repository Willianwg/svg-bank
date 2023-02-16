package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FindUserService {
    private UserRepository userRepository;

    public User execute(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
