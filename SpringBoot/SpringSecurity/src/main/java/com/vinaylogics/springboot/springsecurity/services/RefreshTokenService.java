package com.vinaylogics.springboot.springsecurity.services;

import com.vinaylogics.springboot.springsecurity.models.RefreshToken;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken();
    void deleteRefreshToken(String token);
    void validateRefreshToken(String token);

}
