package com.vinaylogics.springbasics.aop.services;

import com.vinaylogics.springbasics.aop.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
