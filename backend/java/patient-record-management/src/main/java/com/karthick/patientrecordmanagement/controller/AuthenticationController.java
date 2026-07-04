package com.karthick.patientrecordmanagement.controller;

import com.karthick.patientrecordmanagement.dto.request.LoginRequest;
import com.karthick.patientrecordmanagement.dto.response.LoginResponse;
import com.karthick.patientrecordmanagement.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authenticationService.login(request);

    }

}