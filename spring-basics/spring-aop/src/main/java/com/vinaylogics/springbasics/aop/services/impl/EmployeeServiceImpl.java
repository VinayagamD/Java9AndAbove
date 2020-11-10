package com.vinaylogics.springbasics.aop.services.impl;

import com.vinaylogics.springbasics.aop.models.Employee;
import com.vinaylogics.springbasics.aop.repositories.EmployeeRepository;
import com.vinaylogics.springbasics.aop.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
