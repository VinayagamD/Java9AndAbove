package com.vinaylogics.springboot.springsecurity.controllers;

import com.vinaylogics.springboot.springsecurity.dtos.*;
import com.vinaylogics.springboot.springsecurity.services.AuthService;
import com.vinaylogics.springboot.springsecurity.services.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDataDTO<AuthenticationResponse>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(ResponseDataDTO.<AuthenticationResponse>builder()
                .message("Success")
                .success(true)
                .data(service.login(loginRequest))
                .build());
    }

    @PostMapping("/refresh")
    public ResponseEntity<ResponseDataDTO<AuthenticationResponse>> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(ResponseDataDTO.<AuthenticationResponse>builder()
                .message("Success")
                .success(true)
                .data(service.refreshToken(refreshTokenRequest))
                .build());
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseDataDTO<String>> logout(@RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.ok(ResponseDataDTO.<String>builder()
                .message("Success")
                .success(true)
                .data("Refresh Token Delete Successfully")
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDataDTO<RegisterResponse>> register(@RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDataDTO.<RegisterResponse>builder()
                        .message("Success")
                        .success(true)
                        .data(service.registerUser(request))
                        .build());
    }

}
