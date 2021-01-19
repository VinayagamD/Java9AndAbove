package com.vinaylogics.springboot.springsecurity.security;

import com.vinaylogics.springboot.springsecurity.utils.Constants;
import org.springframework.security.core.Authentication;

public interface JwtProvider extends Constants.JwtConstant {

    void init();

    String generateToken(Authentication authentication);

    boolean validateToken(String token);

    String getUsernameFromJwt(String token);

    Long getJwtExpirationInMillis();

    String generateTokenWithUserName(String username);
}
