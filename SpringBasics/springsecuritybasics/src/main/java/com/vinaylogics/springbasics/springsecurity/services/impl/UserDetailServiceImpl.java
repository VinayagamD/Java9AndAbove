package com.vinaylogics.springbasics.springsecurity.services.impl;

import com.vinaylogics.springbasics.springsecurity.models.MyUserDetail;
import com.vinaylogics.springbasics.springsecurity.models.Role;
import com.vinaylogics.springbasics.springsecurity.models.User;
import com.vinaylogics.springbasics.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public MyUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        return new MyUserDetail(user, user.getRoles());
    }
}
