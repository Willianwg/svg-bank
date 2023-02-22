package com.willian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.model.User;
import com.willian.repository.IUserRepository;

@Service
public class ListAllUsersService {
    private IUserRepository userRepository;

    public ListAllUsersService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> execute(){
        return userRepository.findAll();
    }
}
