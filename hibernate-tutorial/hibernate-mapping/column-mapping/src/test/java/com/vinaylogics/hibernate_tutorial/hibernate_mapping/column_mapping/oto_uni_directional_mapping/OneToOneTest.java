package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.oto_uni_directional_mapping;

import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.oto_uni_directional_mapping.Address;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.oto_uni_directional_mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class OneToOneTest {

    File file;
    SessionFactory sessionFactory;
    Session session;
    @BeforeEach
    void setUp() {
        file = new File(OneToOneTest.class.getClassLoader().getResource("hibernate_cm_oto_ud.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testOneToOneUniDirectional(){
        Transaction t = session.beginTransaction();
        Student student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        Address address = new Address();
        address.setAddress("Test Address");
        address.setStreet("Test Street");
        address.setCity("Bangalore");
        student.setAddress(address);
        session.save(student);
        t.commit();
        System.out.println("Save Success full");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}