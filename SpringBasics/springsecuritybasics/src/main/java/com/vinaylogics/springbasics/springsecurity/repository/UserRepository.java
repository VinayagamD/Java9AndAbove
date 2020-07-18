package com.vinaylogics.springbasics.springsecurity.repository;

import com.vinaylogics.springbasics.springsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
