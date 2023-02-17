package com.willian.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.willian.model.enums.TransactionTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "randomname")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TransactionTypes type;

    @ManyToOne
    private User user;

    private String user_email;

    private double amount;

    @CreatedDate
    private Date createdAt;
}
