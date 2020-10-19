package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.AnoAddress;
import org.vinaylogics.hibernatebasics.annotation.models.AnMoEmployee;

import java.io.File;

public class EmployeeComponentMappingExample {

    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        AnoAddress address = new AnoAddress();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setPincode(560084);
        AnMoEmployee employee = new AnMoEmployee();
        employee.setFirstName("Vinay");
        employee.setLastName("Ganesh");
        employee.setAddress(address);
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
