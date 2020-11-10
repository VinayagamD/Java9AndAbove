package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.mto_bidirectional;



import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mto_bidirectional.University;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.mto_bidirectional.Student;
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

public class ManyToOneTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(OneToMany.class.getClassLoader().getResource("hibernate_cm_mto_bd.cfg.xml").getFile());
    }


    @Test
    public void testManyToOneBiDirectional(){
        Transaction t = session.beginTransaction();
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        session.save(student);
        students.add(student);
        student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        session.save(student);
        students.add(student);

        University university = new University();
        university.setName("Vinaylogics");
        university.setCountry("India");
        university.setStudents(students);
        students.forEach(student1 -> {
            student1.setUniversity(university);
        });
        session.save(university);
        t.commit();
        System.out.println("Save Success full");
    }

}
