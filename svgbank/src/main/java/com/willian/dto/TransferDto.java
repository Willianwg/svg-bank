package com.willian.dto;

import lombok.Data;

@Data
public class TransferDto {
    private Long from;
    private Long to;
    private double amount;
    private String password;
}
