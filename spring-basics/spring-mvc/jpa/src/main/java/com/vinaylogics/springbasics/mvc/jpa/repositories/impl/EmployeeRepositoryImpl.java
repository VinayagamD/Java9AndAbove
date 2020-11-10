package com.vinaylogics.springbasics.mvc.jpa.repositories.impl;

import com.vinaylogics.springbasics.mvc.jpa.models.Employee;
import com.vinaylogics.springbasics.mvc.jpa.repositories.EmployeeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = manager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}
