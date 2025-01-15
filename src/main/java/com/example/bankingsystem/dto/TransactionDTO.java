package com.example.bankingsystem.dto;

import com.example.bankingsystem.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long accountId;
    private TransactionType transactionType;
    private Double amount;
    private String description;
}
