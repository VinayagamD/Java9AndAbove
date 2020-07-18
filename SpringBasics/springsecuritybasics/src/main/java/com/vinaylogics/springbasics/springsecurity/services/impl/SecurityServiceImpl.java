package com.vinaylogics.springbasics.springsecurity.services.impl;

import com.vinaylogics.springbasics.springsecurity.models.MyUserDetail;
import com.vinaylogics.springbasics.springsecurity.models.User;
import com.vinaylogics.springbasics.springsecurity.services.SecurityService;
import com.vinaylogics.springbasics.springsecurity.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
@Transactional
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override
    public boolean autoLogin(HttpSession httpSession, String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto login %s successfully!", username));
            httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
            return true;
        }
        return false;
    }

    @Override
    public User getCurrentUser(HttpSession httpSession) {
        Object object = httpSession.getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        SecurityContext sc = object == null? null : object instanceof SecurityContext ? (SecurityContext) object : null;
        Authentication authentication = sc == null? null :  sc.getAuthentication();
        if(authentication == null) return null;
        Object principal = authentication.getPrincipal();
        if(principal == null) return null;
        MyUserDetail userDetail = null;
        if(principal instanceof MyUserDetail)
            userDetail = (MyUserDetail) principal;
        if(userDetail == null) return  null;
        return userDetail.getUser();
    }


}
