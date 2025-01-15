package com.example.bankingsystem.services;


import com.example.bankingsystem.mapper.AccountMapper;
import com.example.bankingsystem.dto.AccountDTO;
import com.example.bankingsystem.dto.AccountDTOResponse;
import com.example.bankingsystem.model.Account;
import com.example.bankingsystem.model.User;
import com.example.bankingsystem.repository.AccountRepository;
import com.example.bankingsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountDTOResponse createAccount(AccountDTO accountDTO) {
        log.info("Starting creating account...");
        log.info("Retrieving user information with id {}", accountDTO.getUserId());
        User user = userRepository.findById(accountDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        log.info("Retrieved user information with id {}", user.getId());
        Account account = AccountMapper.buildAccount(accountDTO, user);
        log.info("Saving account {}", account);
        return AccountMapper.toAccountDTOResponse(accountRepository.save(account));
    }

    public List<AccountDTOResponse> getAllAccounts() {
        log.info("Starting getting all accounts...");
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::toAccountDTOResponse)
                .collect(Collectors.toList());
    }
}

