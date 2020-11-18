package com.vinaylogics.springbasics.security.services;



import com.vinaylogics.springbasics.security.models.User;

import javax.servlet.http.HttpSession;

public interface SecurityService {
    String findLoggedInUsername();

    boolean autoLogin(HttpSession httpSession, String username, String password);

    User getCurrentUser(HttpSession httpSession);
}
