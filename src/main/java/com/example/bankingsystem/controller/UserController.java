package com.example.bankingsystem.controller;

import com.example.bankingsystem.dto.UserDTO;
import com.example.bankingsystem.dto.UserDTOResponse;
import com.example.bankingsystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        log.info("UserController is initialized");
    }

    @PostMapping
    public ResponseEntity<UserDTOResponse> createUser(@RequestBody UserDTO user) {
        log.info("Starting user creation");
        log.info("Creating user for username {}", user.getUsername());
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTOResponse>> getAllUsers() {
        log.info("Starting getAllUsers");
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
