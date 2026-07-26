package com.fleetx.authservice.service.auth;

import com.fleetx.authservice.dto.request.LoginRequest;
import com.fleetx.authservice.dto.request.RegisterRequest;
import com.fleetx.authservice.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}