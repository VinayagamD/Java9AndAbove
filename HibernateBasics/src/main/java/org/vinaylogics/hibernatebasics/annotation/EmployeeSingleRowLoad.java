package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.Employee;

import java.io.File;

public class EmployeeSingleRowLoad {

    public static void main(String[] args) {
        runExistingEmployee();
        runNonExistingEmployee();
    }

    private static void runExistingEmployee() {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Employee employee = session.load(Employee.class, 5);
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
        Employee employee = session.load(Employee.class, 10);
        System.out.println(employee);

        System.out.println("Fetch Successful");
        sessionFactory.close();
        session.close();
    }
}
