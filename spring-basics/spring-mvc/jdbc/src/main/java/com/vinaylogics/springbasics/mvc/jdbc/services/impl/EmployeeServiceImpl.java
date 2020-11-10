package com.vinaylogics.springbasics.mvc.jdbc.services.impl;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;
import com.vinaylogics.springbasics.mvc.jdbc.repositories.EmployeeRepository;
import com.vinaylogics.springbasics.mvc.jdbc.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        return repository.saveEmployee(employee) > 0;
    }
}
