package com.vinaylogics.springboot.springsecurity.services.impl;

import com.vinaylogics.springboot.springsecurity.dtos.*;
import com.vinaylogics.springboot.springsecurity.models.User;
import com.vinaylogics.springboot.springsecurity.repositories.UserRepository;
import com.vinaylogics.springboot.springsecurity.security.JwtProvider;
import com.vinaylogics.springboot.springsecurity.services.AuthService;
import com.vinaylogics.springboot.springsecurity.services.RefreshTokenService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final RefreshTokenService refreshTokenService;
    private final JwtProvider provider;
    private final AuthenticationManager manager;
    private final PasswordEncoder encoder;

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token= provider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(provider.getJwtExpirationInMillis()))
                .username(request.getUsername())
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User prinicipal = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByUsername(prinicipal.getUsername()).orElseThrow(()->
                new UsernameNotFoundException("User name not found - "+prinicipal.getUsername()));
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshTokenRequest request) {
        refreshTokenService.validateRefreshToken(request.getRefreshToken());
        String token = provider.generateTokenWithUserName(request.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(request.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(provider.getJwtExpirationInMillis()))
                .username(request.getUsername())
                .build();
    }

    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setType(request.getType());
        repository.save(user);
        return RegisterResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .type(user.getType())
                .build();
    }
}
