package com.willian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.model.User;
import com.willian.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListAllUsersService {
    private UserRepository userRepository;

    public List<User> execute(){
        return userRepository.findAll();
    }
}
