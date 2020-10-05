package com.vinaylogics.hibernate_tutorial.hibernate_core.annotation_configuration.models;

import com.mysql.cj.xdevapi.AddResult;
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
    void setUp() {
        file = new File(EmployeeHibernateTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testHibernateAnnotation_Save(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Meiyappan");
        employee.setLastName("Franco");
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setPinCode(560001);
        employee.setAddress(address);
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}