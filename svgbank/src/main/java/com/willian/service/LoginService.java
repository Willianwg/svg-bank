package com.willian.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.willian.dto.LoginDto;
import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {
    UserRepository userRepository;

    public User execute(LoginDto loginData){
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        User user = userRepository.findByEmail(loginData.getEmail());

        String encodedPassword = user.getPassword();

        boolean match = bcrypt.matches(loginData.getPassword(), encodedPassword);

        if(match){
            return user;
        }

        return null;

    }
}
