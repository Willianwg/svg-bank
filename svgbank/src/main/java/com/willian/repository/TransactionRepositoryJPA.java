package com.willian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.willian.model.Transaction;

@Repository
public interface TransactionRepositoryJPA extends JpaRepository<Transaction, Long> {

}
