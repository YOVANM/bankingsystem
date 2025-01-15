package com.example.bankingsystem.mapper;

import com.example.bankingsystem.dto.UserDTO;
import com.example.bankingsystem.dto.UserDTOResponse;
import com.example.bankingsystem.model.User;
import com.example.bankingsystem.util.BankingSystemUtil;

import java.time.LocalDateTime;

public class UserMapper {

    public static User buildUser(UserDTO userDTO, String salt) {
        return User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .salt(salt)
                .passwordHash(BankingSystemUtil.hashPassword(userDTO.getPassword(), salt)) // Hashing password
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static UserDTOResponse toUserDTOResponse(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return UserDTOResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
