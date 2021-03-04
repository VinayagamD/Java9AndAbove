package com.vinaylogics.learnadvancejava.jdbc.basics.doas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallableStatementDaoTest {
    CallableStatementDao callableStatementDao;
    @BeforeEach
    void setUp() {
        callableStatementDao = new CallableStatementDao();
    }

    @Test
    void getAllBooks() {
        callableStatementDao.getAllBooks().forEach(System.out::println);
    }

    @Test
    void displayMaxBookPrice() {
        Double result = callableStatementDao.displayMaxBookPrice();
        assertNotNull(result);
        assertTrue(result > 0);
        System.out.println(result);
    }
}