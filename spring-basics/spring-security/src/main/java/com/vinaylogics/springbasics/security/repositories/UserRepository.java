package com.vinaylogics.springbasics.security.repositories;

import com.vinaylogics.springbasics.security.models.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByUsername(String username);
}
