package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.dto.LoginDto;
import com.willian.model.User;
import com.willian.repository.IUserRepository;
import com.willian.utils.IPasswordEncoder;

@Service
public class LoginService {
    private IUserRepository userRepository;
    private IPasswordEncoder passwordEncoder;

    public LoginService(IUserRepository userRepository, IPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User execute(LoginDto loginData){

        User user = userRepository.findByEmail(loginData.getEmail());

        String encodedPassword = user.getPassword();

        boolean match = this.passwordEncoder.compare(loginData.getPassword(), encodedPassword);

        if(match){
            return user;
        }

        return null;

    }
}
