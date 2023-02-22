package com.willian.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.willian.dto.CreateUserDto;
import com.willian.model.User;
import com.willian.repository.IUserRepository;

@Service
public class SignUpService {
    private IUserRepository userRepository;
    
    public SignUpService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(CreateUserDto user){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encodedPassword = bcrypt.encode(user.getPassword());

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encodedPassword);
        
        return this.userRepository.save(newUser);

    }
}
