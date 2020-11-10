package com.vinaylogics.springbasics.mvc.jpa.services;

import com.vinaylogics.springbasics.mvc.jpa.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
