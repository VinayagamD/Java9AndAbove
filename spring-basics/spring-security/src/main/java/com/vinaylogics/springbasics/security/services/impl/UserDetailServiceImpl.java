package com.vinaylogics.springbasics.security.services.impl;

import com.vinaylogics.springbasics.security.models.MyUserDetail;
import com.vinaylogics.springbasics.security.models.User;
import com.vinaylogics.springbasics.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        return new MyUserDetail(user, user.getRoles());
    }
}
