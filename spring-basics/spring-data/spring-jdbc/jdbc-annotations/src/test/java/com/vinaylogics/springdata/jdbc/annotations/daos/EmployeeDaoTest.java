package com.vinaylogics.springdata.jdbc.annotations.daos;

import com.vinaylogics.springdata.jdbc.annotations.config.EmployeeDataConfig;
import com.vinaylogics.springdata.jdbc.annotations.models.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    ClassPathXmlApplicationContext context;

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

    @AfterEach
    void teardown(){
        context.close();
    }
}