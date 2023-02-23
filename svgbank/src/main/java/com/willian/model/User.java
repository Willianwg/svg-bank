package com.willian.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @OneToMany
    private List<Transaction> transactions = new ArrayList<>();

    private double balance = 100;

    public void credit(double amount){
        this.balance += amount;
    }

    public boolean debit(double amount){
        if(balance >= amount){
            this.balance -= amount;

            return true;
        }

        return false;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
    }
}
