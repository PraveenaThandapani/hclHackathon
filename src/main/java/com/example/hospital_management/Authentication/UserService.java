package com.example.hospital_management.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService; // you MUST implement this

    // 🔐 Register
    public void register(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password)); // ✅ FIXED
        System.out.println("from authservice");

        userRepository.save(user);
    }

    // 🔐 Login
    public String login(String userName, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password) // ✅ FIXED
        );


        return jwtService.generateToken(userName);
    }
}