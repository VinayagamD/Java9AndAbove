package com.vinaylogics.springbasics.springmvcdemo.dao;

import com.vinaylogics.springbasics.springmvcdemo.models.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:webapp/WEB-INF/applicationConfig.xml")
@WebAppConfiguration
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveEmployee() {
        Employee employee = new Employee();
        employee.setName("Astro");
        employee.setSalary(12000.00f);
        employeeRepository.saveEmployee(employee);
    }

    @Test
    void testGetEmployees() {
        employeeRepository.getEmployees().forEach(System.out::println);
    }

    @DisplayName("Test for select named parameter query")
    @ParameterizedTest(name = "For name {0} insertion is tested.")
    @ValueSource(ints = {1,2,3,4,5})
    @Transactional(readOnly = true)
    void testGetEmployeeById(int id) {
        System.out.println(employeeRepository.getEmployeeById(id));
    }
}