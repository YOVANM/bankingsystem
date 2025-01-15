package com.example.bankingsystem.services;

import com.example.bankingsystem.dto.TransactionDTO;
import com.example.bankingsystem.dto.TransactionDTOResponse;
import com.example.bankingsystem.mapper.TransactionMapper;
import com.example.bankingsystem.model.Account;
import com.example.bankingsystem.model.Transaction;
import com.example.bankingsystem.repository.AccountRepository;
import com.example.bankingsystem.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionDTOResponse createTransaction(TransactionDTO transactionDTO) {
        Account account = accountRepository.findById(transactionDTO.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Transaction transaction = TransactionMapper.toTransaction(transactionDTO, account);
        return TransactionMapper.toTransactionDTOResponse(transactionRepository.save(transaction));
    }

    public List<TransactionDTOResponse> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionMapper::toTransactionDTOResponse)
                .collect(Collectors.toList());
    }
}
