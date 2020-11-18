package com.vinaylogics.springbasics.security.services;

import com.vinaylogics.springbasics.security.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
