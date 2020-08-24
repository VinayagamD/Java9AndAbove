package com.vinaylogics.hibernatetraining.annotations;

import com.vinaylogics.hibernatetraining.annotations.models.Employee;
import com.vinaylogics.hibernatetraining.annotations.models.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateAnnotationDemo {

    public static void main(String[] args) {
        File file = new File(HibernateAnnotationDemo.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Saini");
        employee.setLastName("Supreet");
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setPincode(123456);
        employee.setAddress(address);
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
