package com.willian.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.willian.dto.LoginDto;
import com.willian.model.User;
import com.willian.repository.IUserRepository;

@Service
public class LoginService {
    private IUserRepository userRepository;

    public LoginService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
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
