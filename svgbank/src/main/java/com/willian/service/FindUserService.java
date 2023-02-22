package com.willian.service;

import org.springframework.stereotype.Service;

import com.willian.model.User;
import com.willian.repository.IUserRepository;


@Service
public class FindUserService {
    private IUserRepository userRepository;

    public FindUserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(Long id){
        return userRepository.findById(id);
    }
}
