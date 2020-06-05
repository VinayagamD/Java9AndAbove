package com.vinaylogics.schoolmanagement.services;

import com.vinaylogics.schoolmanagement.models.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> getTeachers();
}
