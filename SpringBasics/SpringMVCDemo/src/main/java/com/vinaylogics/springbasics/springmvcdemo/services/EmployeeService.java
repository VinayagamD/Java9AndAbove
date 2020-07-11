package com.vinaylogics.springbasics.springmvcdemo.services;

import com.vinaylogics.springbasics.springmvcdemo.models.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();
     Employee findById(Integer id);
     boolean saveEmployee(Employee employee);
}
