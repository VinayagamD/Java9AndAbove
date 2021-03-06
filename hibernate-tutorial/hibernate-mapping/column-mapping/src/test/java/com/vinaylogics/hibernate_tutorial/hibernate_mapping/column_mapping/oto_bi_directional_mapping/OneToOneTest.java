package com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.oto_bi_directional_mapping;


import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.oto_bi_directional_mapping.Address;
import com.vinaylogics.hibernate_tutorial.hibernate_mapping.column_mapping.models.oto_bi_directional_mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class OneToOneTest extends BaseTestClass {



    @Override
    protected File getFile() {
        return new File(OneToOneTest.class.getClassLoader().getResource("hibernate_cm_oto_bd.cfg.xml").getFile());
    }

    @Test
    public void testOneToOneBiDirectional(){
        Transaction t = session.beginTransaction();
        Student student = new Student();
        student.setFirstName("Meiyappan");
        student.setLastName("Student");
        student.setSection("Java Training");
        Address address = new Address();
        address.setAddress("Test Address");
        address.setStreet("Test Street");
        address.setCity("Bangalore");
        address.setStudent(student);
        student.setAddress(address);
        session.save(student);
        session.save(address);
        t.commit();
        System.out.println("Save Success full");
    }
}