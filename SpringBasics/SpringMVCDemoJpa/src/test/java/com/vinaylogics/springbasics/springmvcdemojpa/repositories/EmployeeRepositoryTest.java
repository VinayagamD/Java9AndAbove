package com.vinaylogics.springbasics.springmvcdemojpa.repositories;

import com.vinaylogics.springbasics.springmvcdemojpa.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:mvc-configs.xml"})
@WebAppConfiguration
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    void testFindAll() {
       List<Employee> employees = repository.findAll();
       employees.forEach(System.out::println);
    }
}