package com.example.bankingsystem.mapper;

import com.example.bankingsystem.dto.TransactionDTO;
import com.example.bankingsystem.dto.TransactionDTOResponse;
import com.example.bankingsystem.model.Account;
import com.example.bankingsystem.model.Transaction;

import java.time.LocalDateTime;

public class TransactionMapper {
    public static Transaction toTransaction(TransactionDTO transactionDTO, Account account) {
        return Transaction.builder()
                .account(account)
                .transactionType(transactionDTO.getTransactionType())
                .amount(transactionDTO.getAmount())
                .description(transactionDTO.getDescription())
                .transactionDate(LocalDateTime.now())
                .build();
    }

    public static TransactionDTOResponse toTransactionDTOResponse(Transaction transaction) {
        return TransactionDTOResponse.builder()
                .id(transaction.getId())
                .accountId(transaction.getAccount().getId())
                .transactionType(transaction.getTransactionType())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .transactionDate(transaction.getTransactionDate())
                .build();
    }
}
