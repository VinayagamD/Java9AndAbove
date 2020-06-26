package com.vinaylogics.nativequery.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class EmployeeStoredProcedureTest {
    private SessionFactory sessionFactory;
    private Session session;

    @BeforeEach
    public void setUp(){
        File file = new File(Employee.class.getClassLoader().getResource("hibernate-native.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void startTest(){
        System.out.println("");
    }

    @AfterEach
    public void tearDown(){
        session.close();
        sessionFactory.close();
    }

}
