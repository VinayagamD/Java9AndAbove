package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.mtm_unidirectional;

import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mtm_unidirectional.Classes;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mtm_unidirectional.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.OneToMany;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ManyToManyTest {
    File file;
    SessionFactory sessionFactory;
    Session session;

    @BeforeEach
    void setUp() {
        file = new File(OneToMany.class.getClassLoader().getResource("hibernate_cm_mtm_ud.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testManyToManyAssociation(){
        Transaction transaction = session.beginTransaction();
        Set<Student> studentSet = new HashSet<>();

        IntStream.rangeClosed(1,10).forEach(i->{
            Student student = new Student();
            student.setFirstName("Student First "+i);
            student.setLastName("Student Last "+i);
            student.setSection("Java");
            studentSet.add(student);
        });

        Classes classes = new Classes();
        classes.setName("Java Frameworks");
        classes.setSubject("Hibernate");
        classes.setStudents(studentSet);
        session.save(classes);
        transaction.commit();
        System.out.println("Saved Successfully");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}