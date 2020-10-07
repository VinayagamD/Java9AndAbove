package com.vinaylogics.designpattern.others.mvc.services.impl;

import com.vinaylogics.designpattern.others.mvc.daos.EmployeeDao;
import com.vinaylogics.designpattern.others.mvc.daos.impl.EmployeeDaoImpl;
import com.vinaylogics.designpattern.others.mvc.services.EmployeeService;
import com.vinaylogics.designpattern.exception.ServiceException;
import com.vinaylogics.designpattern.others.dto.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public List<Employee> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long aLong) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> save(Employee employee) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee employee, Long aLong) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Employee employee) throws ServiceException {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) throws ServiceException {
        return false;
    }
}
