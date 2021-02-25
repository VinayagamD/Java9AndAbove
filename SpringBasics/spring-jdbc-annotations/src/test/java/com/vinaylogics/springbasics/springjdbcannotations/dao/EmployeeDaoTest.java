package com.vinaylogics.springbasics.springjdbcannotations.dao;

import com.vinaylogics.springbasics.springjdbcannotations.configs.JDBCConfigs;
import com.vinaylogics.springbasics.springjdbcannotations.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Annotation JDBC Configs")
class EmployeeDaoTest {

    AnnotationConfigApplicationContext context;

    @BeforeEach
    void setUp(){
        context = new AnnotationConfigApplicationContext();
        context.register(JDBCConfigs.class);
        context.refresh();
    }

    @Test
    void saveEmployee() {
        EmployeeDao employeeDao = context.getBean( EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("Vinay2");
        employee.setSalary(100000.00f);
        employeeDao.saveEmployee(employee);
    }

    @Test
    void getAllEmployees(){
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        employeeDao.findAll().forEach(System.out::println);
    }

}