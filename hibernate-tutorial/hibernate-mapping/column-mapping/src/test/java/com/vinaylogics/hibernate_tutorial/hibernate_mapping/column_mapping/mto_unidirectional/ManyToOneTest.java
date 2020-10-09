package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.mto_unidirectional;


import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mto_unidirectional.Student;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mto_unidirectional.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.OneToMany;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ManyToOneTest {

    File file;
    SessionFactory sessionFactory;
    Session session;
    @BeforeEach
    void setUp() {
        file = new File(OneToMany.class.getClassLoader().getResource("hibernate_cm_mto_ud.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testManyToOneUniDirectional(){
        Transaction t = session.beginTransaction();
        University university = new University();
        university.setName("Vinaylogics");
        university.setCountry("India");
        session.save(university);

        Student student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        student.setUniversity(university);
        session.save(student);
        student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        student.setUniversity(university);
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
