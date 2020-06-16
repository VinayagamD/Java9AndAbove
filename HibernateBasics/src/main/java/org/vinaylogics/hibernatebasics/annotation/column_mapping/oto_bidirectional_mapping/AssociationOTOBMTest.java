package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_bidirectional_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.EmployeeAnnotationTest;
import org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_bidirectional_mapping.model.Address;
import org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_bidirectional_mapping.model.Student;


import java.io.File;

public class AssociationOTOBMTest {
    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate_assoication_otobm.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Student student = new Student();
        student.setFirstName("Saini");
        student.setLastName("Supreet");
        student.setSection("JavaB1");
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setStreet("Bangalore Street");
        System.out.println(student);
        student.setAddress(address);
        session.save(student);
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
