package com.vinaylogics.springboot.springsecurity.security.impl;

import com.vinaylogics.springboot.springsecurity.exceptions.SpringSecureException;
import com.vinaylogics.springboot.springsecurity.security.JwtProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtProviderImpl implements JwtProvider {
    private KeyStore keyStore;

    @Value("${jwt.expiration.time}")
    private Long jwtExpirationInMillis;

    @PostConstruct
    @Override
    public void init() {
        try{
            keyStore = KeyStore.getInstance(JKS);
            InputStream inputStream = getClass().getResourceAsStream(JKS_FILENAME);
            keyStore.load(inputStream, PASSWORD.toCharArray());
        }catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new SpringSecureException("Exception occurred while loading keystore");
        }
    }

    @Override
    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        Jwts.parserBuilder().setSigningKey(getPublicKey()).build().parseClaimsJws(token);
        return true;
    }

    @Override
    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    @Override
    public Long getJwtExpirationInMillis() {
        return jwtExpirationInMillis;
    }

    @Override
    public String generateTokenWithUserName(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(Date.from(Instant.now()))
                .signWith(getPrivateKey())
                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey(KEY, PASSWORD.toCharArray() );
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new SpringSecureException("Exception occurred while retrieving public key from keystore");
        }
    }

    private PublicKey getPublicKey(){
        try {
            return keyStore.getCertificate(KEY).getPublicKey();
        } catch (KeyStoreException e) {
            throw new SpringSecureException("Exception occurred while retrieving public key from keystore");
        }
    }
}
