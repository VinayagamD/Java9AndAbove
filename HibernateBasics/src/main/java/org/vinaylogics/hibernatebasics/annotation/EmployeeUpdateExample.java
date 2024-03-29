package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.AnMoEmployee;

import java.io.File;
import java.util.List;

public class EmployeeUpdateExample {

    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<AnMoEmployee> employees = session.createQuery("SELECT a FROM CMyEmployee a", AnMoEmployee.class).list();
        System.out.println("Fetch Successful");
        sessionFactory.close();
        session.close();

        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AnMoEmployee employee =  employees.get(0);
        System.out.println(employee);
        employee.setFirstName("Updated Name");
        session.update(employee);
        transaction.commit();
        sessionFactory.close();
        session.close();


    }
}
