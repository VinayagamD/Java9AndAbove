package com.vinaylogics.springboot.springsecurity.services.impl;

import com.vinaylogics.springboot.springsecurity.exceptions.SpringSecureException;
import com.vinaylogics.springboot.springsecurity.models.RefreshToken;
import com.vinaylogics.springboot.springsecurity.repositories.RefreshTokenRepository;
import com.vinaylogics.springboot.springsecurity.services.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository repository;

    @Override
    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreateDate(Instant.now());
        return repository.save(refreshToken);
    }

    @Override
    public void deleteRefreshToken(String token) {
        RefreshToken refreshToken = repository.findByToken(token).orElseThrow(()-> new SpringSecureException("Invalid Refresh token"));
        repository.delete(refreshToken);
    }

    @Override
    public void validateRefreshToken(String token) {
        repository.findByToken(token)
                .orElseThrow(()-> new SpringSecureException("Invalid Refresh token"));
    }
}
