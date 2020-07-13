package com.vinaylogics.springbasics.springmvcdemojpa.services;

import com.vinaylogics.springbasics.springmvcdemojpa.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
