package com.diogosilva.walletcore.auth.controllers;

import com.diogosilva.walletcore.auth.dto.LoginRequest;
import com.diogosilva.walletcore.users.repositories.AdminRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return adminRepository.findByUsername(loginRequest.username())
            .map(admin -> {
                if (passwordEncoder.matches(loginRequest.password(), admin.getPassword())) {
                    
                    return ResponseEntity.ok().body("{\"message\": \"Login sucess\", \"token\": \"fake-jwt-token\"}");
                }
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password incorreta");
            })
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilizador não encontrado"));
    }
}