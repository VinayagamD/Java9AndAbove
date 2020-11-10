package com.vinaylogics.springbasics.mvc.jpa.repositories;

import com.vinaylogics.springbasics.mvc.jpa.models.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();
    Employee findById(Integer id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    boolean delete(Employee employee);
    boolean deleteById(Integer id);
}
