package com.example.bankingsystem.services;

import com.example.bankingsystem.mapper.UserMapper;
import com.example.bankingsystem.dto.UserDTO;
import com.example.bankingsystem.dto.UserDTOResponse;
import com.example.bankingsystem.model.User;
import com.example.bankingsystem.repository.UserRepository;
import com.example.bankingsystem.util.BankingSystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        log.info("UserService is initialized");
    }
    public UserDTOResponse createUser(UserDTO user) {
        log.info("Calling createUser repository");
        User userCreated = userRepository.save(UserMapper.buildUser(user, BankingSystemUtil.generateSalt()));
        log.info("User created successfully with id {}", userCreated.getId());
        return UserMapper.toUserDTOResponse(userCreated);

    }

    public List<UserDTOResponse> getAllUsers() {
        log.info("Calling getAllUsers repository");
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDTOResponse)
                .collect(Collectors.toList());
    }
}
