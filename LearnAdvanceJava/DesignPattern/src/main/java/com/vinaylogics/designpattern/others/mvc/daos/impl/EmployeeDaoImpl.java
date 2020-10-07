package com.vinaylogics.designpattern.others.mvc.daos.impl;

import com.vinaylogics.designpattern.exception.DaoException;
import com.vinaylogics.designpattern.others.dto.Employee;
import com.vinaylogics.designpattern.others.mvc.daos.EmployeeDao;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long aLong) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> save(Employee employee) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee employee, Long aLong) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean delete(Employee employee) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) throws DaoException {
        return false;
    }
}
