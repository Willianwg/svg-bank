package com.willian.repository;

import java.util.List;

import com.willian.model.User;

public interface IUserRepository {
    public User findByEmail(String email);
    public User findById(Long id);
    public User save(User user);
    public List<User> findAll();
}
