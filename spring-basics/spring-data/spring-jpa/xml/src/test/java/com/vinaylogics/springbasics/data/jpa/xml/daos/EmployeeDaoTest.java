package com.vinaylogics.springbasics.data.jpa.xml.daos;

import com.vinaylogics.springbasics.data.jpa.xml.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    ApplicationContext context;
    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("application-config.xml");
    }

    @Test
    void saveEmployee() {
        EmployeeDao employeeDao = context.getBean("edao", EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("Bhuvana");
        employee.setSalary(1000000.00f);
        employeeDao.saveEmployee(employee);
    }

    @Test
    void findAll() {
        EmployeeDao employeeDao = context.getBean("edao", EmployeeDao.class);
        employeeDao.findAll().forEach(System.out::println);
    }
}