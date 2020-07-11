package com.vinaylogics.springbasics.springmvcdemo.services.impl;

import com.vinaylogics.springbasics.springmvcdemo.models.Employee;
import com.vinaylogics.springbasics.springmvcdemo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.vinaylogics.springbasics.springmvcdemo.services.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.getEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.getEmployeeById(id);
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        return repository.saveEmployee(employee) > 0;
    }
}
