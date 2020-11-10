package com.vinaylogics.springbasics.mvc.jdbc.services;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(Integer id);
    boolean saveEmployee(Employee employee);
}
