package com.vinaylogics.springbasics.springsecurity.services;

import com.vinaylogics.springbasics.springsecurity.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
