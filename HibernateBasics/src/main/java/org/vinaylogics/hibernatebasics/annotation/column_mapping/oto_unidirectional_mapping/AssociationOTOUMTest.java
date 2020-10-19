package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.EmployeeAnnotationTest;
import org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping.model.OTOUMAddress;
import org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping.model.OTOUMStudent;

import java.io.File;

public class AssociationOTOUMTest {
    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate_assoication_otoum.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OTOUMStudent student = new OTOUMStudent();
        student.setFirstName("Saini");
        student.setLastName("Supreet");
        student.setSection("JavaB1");
        OTOUMAddress address = new OTOUMAddress();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setStreet("Bangalore Street");
        System.out.println(student);
        student.setAddress(address);
        session.save(student);
        transaction.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
