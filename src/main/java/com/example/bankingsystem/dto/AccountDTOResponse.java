package com.example.bankingsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AccountDTOResponse {
    private Integer id;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

