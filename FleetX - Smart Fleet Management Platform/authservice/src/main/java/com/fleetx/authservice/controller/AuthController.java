package com.fleetx.authservice.controller;

import com.fleetx.authservice.dto.request.RegisterRequest;
import com.fleetx.authservice.dto.response.ApiResponse;
import com.fleetx.authservice.dto.response.AuthResponse;
import com.fleetx.authservice.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fleetx.authservice.dto.request.LoginRequest;



    @RestController
    @RequestMapping("/api/auth")
    @RequiredArgsConstructor
    public class AuthController {

        private final AuthService authService;

        @PostMapping("/register")
        public ResponseEntity<ApiResponse<AuthResponse>> register(
                @Valid @RequestBody RegisterRequest request) {

            AuthResponse authResponse = authService.register(request);

            ApiResponse<AuthResponse> response = ApiResponse.<AuthResponse>builder()
                    .success(true)
                    .message("User registered successfully")
                    .data(authResponse)
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PostMapping("/login")
        public ResponseEntity<ApiResponse<AuthResponse>> login(
                @Valid @RequestBody LoginRequest request) {

            AuthResponse authResponse = authService.login(request);

            ApiResponse<AuthResponse> response = ApiResponse.<AuthResponse>builder()
                    .success(true)
                    .message("Login successful")
                    .data(authResponse)
                    .build();

            return ResponseEntity.ok(response);
        }
    }