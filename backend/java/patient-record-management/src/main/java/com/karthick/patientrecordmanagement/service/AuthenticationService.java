package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.request.LoginRequest;
import com.karthick.patientrecordmanagement.dto.response.LoginResponse;
import com.karthick.patientrecordmanagement.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        String token = jwtService.generateToken(authentication.getName());

        String role = authentication.getAuthorities()
                .stream()
                .findFirst()
                .map(a -> a.getAuthority())
                .orElse("");

        return new LoginResponse(
                token,
                authentication.getName(),
                role
        );
    }

}