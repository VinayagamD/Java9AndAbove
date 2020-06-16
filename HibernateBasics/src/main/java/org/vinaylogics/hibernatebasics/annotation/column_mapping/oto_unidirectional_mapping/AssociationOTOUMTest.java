package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.EmployeeAnnotationTest;

import java.io.File;

public class EmployeeJoinedTableClassTableTest {
    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate_imjtc.cfg.xml").getFile());
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
