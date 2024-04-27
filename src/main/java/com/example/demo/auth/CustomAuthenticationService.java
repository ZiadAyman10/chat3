package com.example.demo.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationService {

    private Map<String, String> users = new HashMap<>();

    public CustomAuthenticationService() {
        // Initialize with some default users and passwords
        users.put("user1", "$2a$10$WrWsY2i3PBRulVgUoUI7r.jhQGJqANsFD0/kKdpt.p2f2q8N8ztYu"); // Password: password1
        users.put("user2", "$2a$10$Mcl8oPUANeR2zTpy9MhSyeaJbUa.SXtXLyJfQGqgBfqUzPc.aZn8u"); // Password: password2
    }

    public boolean authenticate(String username, String password) {
        // Check if the username exists and the password matches the hashed password
        String hashedPassword = users.get(username);
        if (hashedPassword != null && BCrypt.checkpw(password, hashedPassword)) {
            return true;
        }
        return false;
    }
}

