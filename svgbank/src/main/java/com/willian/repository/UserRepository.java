package com.willian.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.willian.model.User;

@Service
public class UserRepository implements IUserRepository {

    @Autowired
    UserRepositoryJPA userRepositoryJPA;

    @Override
    public User findByEmail(String email) {
        User user = userRepositoryJPA.findByEmail(email);

        return user;
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepositoryJPA.findById(id);

        return user.orElse(null);
    }

    @Override
    public User save(User user) {
       return userRepositoryJPA.save(user);
    }

    @Override
    public List<User> findAll() {
       return userRepositoryJPA.findAll().stream().peek(user -> user.setPassword(null)).collect(Collectors.toList());
    }

}
