package com.vinaylogics.springboot.springsecurity.repositories;

import com.vinaylogics.springboot.springsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
