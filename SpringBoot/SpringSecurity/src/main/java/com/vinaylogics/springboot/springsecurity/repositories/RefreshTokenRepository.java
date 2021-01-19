package com.vinaylogics.springboot.springsecurity.repositories;

import com.vinaylogics.springboot.springsecurity.models.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByToken(String token);
}
