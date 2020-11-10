package com.vinaylogics.springbasics.mvc.jdbc.repositories;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:mvc-configs.xml"})
@WebAppConfiguration
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void saveEmployee() {
        Employee employee = new Employee();
        employee.setName("Astro");
        employee.setSalary(12000.00f);
        employeeRepository.saveEmployee(employee);
    }

    @Test
    void findAll() {
        employeeRepository.findAll().forEach(System.out::println);
    }

    @ParameterizedTest(name = "For Employee with id = {0}")
    @ValueSource(ints = {1,2,3,4,5})
    @Transactional(readOnly = true)
    void findById(int id) {
        System.out.println(employeeRepository.findById(id));
    }
}