package com.vinaylogics.springbasics.springdata.jpa.annotations.daos.impl;


import com.vinaylogics.springbasics.springdata.jpa.annotations.daos.EmployeeDao;
import com.vinaylogics.springbasics.springdata.jpa.annotations.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final SessionFactory sessionFactory;

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        TypedQuery<Employee> query = session.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }
}
