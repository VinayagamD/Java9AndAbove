package org.vinaylogics.hibernatebasics.xmlconfiguration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.xmlconfiguration.models.XmlEmployee;

import java.io.File;

public class EmployeeXMLTest {
    public static void main(String[] args) {
        File file = new File(EmployeeXMLTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        XmlEmployee xmlEmployee = new XmlEmployee();
        xmlEmployee.setId(102);
        xmlEmployee.setFirstName("Saini");
        xmlEmployee.setLastName("Supreet");

        session.save(xmlEmployee);
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
