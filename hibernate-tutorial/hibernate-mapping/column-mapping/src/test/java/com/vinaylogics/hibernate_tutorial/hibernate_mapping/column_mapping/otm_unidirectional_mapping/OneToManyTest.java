package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.otm_unidirectional_mapping;


import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.otm_unidirectional.Student;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.otm_unidirectional.University;
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

public class OneToManyTest {

    File file;
    SessionFactory sessionFactory;
    Session session;
    @BeforeEach
    void setUp() {
        file = new File(OneToMany.class.getClassLoader().getResource("hibernate_cm_otm_ud.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testOneToOneBiDirectional(){
        Transaction t = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        students.add(student);
        student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        students.add(student);

        University university = new University();
        university.setName("Vinaylogics");
        university.setCountry("India");
        university.setStudents(students);
        session.save(university);
        t.commit();
        System.out.println("Save Success full");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}
