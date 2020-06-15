package org.vinaylogics.hibernatebasics.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.models.Address;
import org.vinaylogics.hibernatebasics.annotation.models.Employee;

import java.io.File;

import static com.oracle.jrockit.jfr.ContentType.Address;

public class EmployeeComponentMappingExample {

    public static void main(String[] args) {
        File file = new File(EmployeeAnnotationTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setPincode(560084);
        Employee employee = new Employee();
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
