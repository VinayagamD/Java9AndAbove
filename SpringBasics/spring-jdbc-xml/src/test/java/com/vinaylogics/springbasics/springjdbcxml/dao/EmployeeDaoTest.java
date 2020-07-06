package com.vinaylogics.springbasics.springjdbcxml.dao;

import com.vinaylogics.springbasics.springjdbcxml.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveEmployee() {
        EmployeeDao employeeDao = context.getBean("edao", EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("Astro");
        employee.setSalary(12000.00f);
        employeeDao.saveEmployee(employee);
    }
}