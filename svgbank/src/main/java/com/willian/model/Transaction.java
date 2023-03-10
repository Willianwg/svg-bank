package com.willian.model;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.willian.model.enums.TransactionTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

    private double amount;

    private String sent_by;

    private String received_by;

    @CreatedDate
    private Date createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
    }
}
