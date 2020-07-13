package com.vinaylogics.springbasics.springmvcdemojpa.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Test
    void testFindAll() {
        repository.findAll().forEach(System.out::println);
    }
}