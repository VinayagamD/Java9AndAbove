package com.vinaylogics.schoolmanagement.services.impl;

import com.vinaylogics.schoolmanagement.models.User;
import com.vinaylogics.schoolmanagement.repositories.providers.UserProvider;
import com.vinaylogics.schoolmanagement.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserProvider provider;

    public UserServiceImpl() {
        provider = UserProvider.getInstance();
    }

    @Override
    public List<User> findAll() {
        return provider.getStudents();
    }

    @Override
    public User findById(Long id) {
        return provider.findStudentId(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getTeachers() {
        return provider.getTeachers();
    }
}
