package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.dto.CreateUserDto;
import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SignInService {
    private UserRepository userRepository;

    public void execute(CreateUserDto user){
        
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        
        userRepository.save(newUser);

    }
}
