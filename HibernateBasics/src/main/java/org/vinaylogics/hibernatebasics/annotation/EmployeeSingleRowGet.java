package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.AnMoEmployee;

import java.io.File;

public class EmployeeSingleRowGet {

    public static void main(String[] args) {
        runExistingEmployee();
        runNonExistingEmployee();
    }

    private static void runExistingEmployee() {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        AnMoEmployee employee = session.get(AnMoEmployee.class, 5);
        System.out.println(employee);

        System.out.println("Fetch Successful");
        sessionFactory.close();
        session.close();
    }
    private static void runNonExistingEmployee() {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        AnMoEmployee employee = session.get(AnMoEmployee.class, 10);
        System.out.println(employee);

        System.out.println("Fetch Successful");
        sessionFactory.close();
        session.close();
    }
}
