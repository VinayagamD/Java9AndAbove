package com.vinaylogics.springbasics.springsecurity.services;

import com.vinaylogics.springbasics.springsecurity.models.User;

import javax.servlet.http.HttpSession;

public interface SecurityService {

    String findLoggedInUsername();

    boolean autoLogin(HttpSession httpSession, String username, String password);

    User getCurrentUser(HttpSession httpSession);
}
