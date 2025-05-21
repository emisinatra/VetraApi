package com.example.vetra;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";
        String hash = encoder.encode(rawPassword);
        System.out.println("Hash para 'admin123': " + hash);
    }
} 