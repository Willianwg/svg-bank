package com.willian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.willian.model.User;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
