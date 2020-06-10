package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.Employee;

import java.io.File;
import java.util.ArrayList;

public class EmployeeFetchExample {

    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.createQuery("SELECT a FROM Employee a", Employee.class).list().forEach(System.out::println);
        System.out.println("Fetch Successful");
        sessionFactory.close();
        session.close();
    }
}
