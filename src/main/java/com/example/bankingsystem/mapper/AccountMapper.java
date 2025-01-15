package com.example.bankingsystem.mapper;

import com.example.bankingsystem.dto.AccountDTO;
import com.example.bankingsystem.dto.AccountDTOResponse;
import com.example.bankingsystem.model.Account;
import com.example.bankingsystem.model.User;

import java.time.LocalDateTime;

public class AccountMapper {
    public static Account buildAccount(AccountDTO accountDTO, User user) {
        return Account.builder()
                .user(user)
                .accountNumber(accountDTO.getAccountNumber())
                .accountType(accountDTO.getAccountType())
                .balance(accountDTO.getBalance())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static AccountDTOResponse toAccountDTOResponse(Account account) {
        return AccountDTOResponse.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }
}

