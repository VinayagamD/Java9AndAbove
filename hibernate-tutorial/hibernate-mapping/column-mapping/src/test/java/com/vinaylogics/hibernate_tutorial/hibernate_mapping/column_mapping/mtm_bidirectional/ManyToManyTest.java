package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.mtm_bidirectional;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mtm_bidirectional.Classes;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mtm_bidirectional.Student;
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

class ManyToManyTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(OneToMany.class.getClassLoader().getResource("hibernate_cm_mtm_bd.cfg.xml").getFile());
    }


    @Test
    public void testManyToManyAssociation(){
        Transaction transaction = session.beginTransaction();
        Set<Student> studentSet = new HashSet<>();
        Set<Classes> classesSet = new HashSet<>();

        IntStream.rangeClosed(1,10).forEach(i->{
            Student student = new Student();
            student.setFirstName("Student First "+i);
            student.setLastName("Student Last "+i);
            student.setSection("Java");
            studentSet.add(student);
        });
        studentSet.forEach(student -> session.save(student));
        IntStream.rangeClosed(1,10).forEach(i -> {
            Classes classes = new Classes();
            classes.setName("Classes "+i);
            classes.setSubject("Subject "+i);
            classes.setStudents(studentSet);
            classesSet.add(classes);
        });
        classesSet.forEach(classes -> session.save(classes));
        studentSet.forEach(student -> student.setClasses(classesSet));
        studentSet.forEach(student -> session.save(student));
        transaction.commit();
        System.out.println("Saved Successfully");
    }
}