package com.example.bankingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {
    private Long userId;
    private String accountNumber;
    private String accountType; // Enum: SAVINGS or CURRENT
    private Double balance;
}

