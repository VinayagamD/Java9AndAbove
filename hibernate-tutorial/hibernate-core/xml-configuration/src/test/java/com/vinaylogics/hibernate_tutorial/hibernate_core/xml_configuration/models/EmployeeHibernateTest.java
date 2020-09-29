package com.vinaylogics.hibernate_tutorial.hibernate_core.xml_configuration.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeHibernateTest {
    File file;
    SessionFactory sessionFactory;
    Session session;
    @BeforeEach
    public void setUp(){
        file = new File(EmployeeHibernateTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testLoadConfigurationAndCreateTable(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setId(115);
        employee.setFirstName("Meiyappan");
        employee.setLastName("Franco");

        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
    }

    @AfterEach
    public void cleanUp(){
        session.close();
        sessionFactory.close();
    }

}