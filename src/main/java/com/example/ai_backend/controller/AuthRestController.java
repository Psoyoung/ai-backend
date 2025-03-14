package com.example.ai_backend.controller;

import com.example.ai_backend.dto.LoginRequest;
import com.example.ai_backend.dto.LoginResponse;
import com.example.ai_backend.entity.User;
import com.example.ai_backend.repository.UserRepository;
import com.example.ai_backend.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthRestController {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        String token = jwtTokenProvider.createToken(user.getUsername());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
