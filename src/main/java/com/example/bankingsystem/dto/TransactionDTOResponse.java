package com.example.bankingsystem.dto;

import com.example.bankingsystem.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTOResponse {
    private Integer id;
    private Integer accountId;
    private TransactionType transactionType;
    private Double amount;
    private String description;
    private LocalDateTime transactionDate;
}
