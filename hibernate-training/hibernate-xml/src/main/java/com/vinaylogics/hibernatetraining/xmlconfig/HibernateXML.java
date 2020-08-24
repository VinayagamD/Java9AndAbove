package com.vinaylogics.hibernatetraining.xmlconfig;

import com.vinaylogics.hibernatetraining.xmlconfig.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateXML {

    public static void main(String[] args) {
        File file = new File(HibernateXML.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setId(110);
        employee.setFirstName("Saini");
        employee.setLastName("Supreet");

        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
