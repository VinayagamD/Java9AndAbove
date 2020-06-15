package org.vinaylogics.hibernatebasics.annotation.inheritance_mapping.mapped_supperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.EmployeeAnnotationTest;

import java.io.File;

public class EmployeeMappedSuperClassTableTest {
    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate_immsc.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();

        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
