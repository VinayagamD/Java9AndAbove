package org.vinaylogics.hibernatebasics.annotation.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class EmployeeHQLUpdateEmployee {


    public static void main(String[] args) {
        File file = new File(EmployeeHQLUpdateEmployee.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql  = " UPDATE HqlEmployee e set e.firstName = :firstName WHERE e.id= :id";
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        Query query = session.createQuery(hql);
        query.setParameter("firstName", "Vinay");
        query.setParameter("id", 50);
        int result = query.executeUpdate();
        System.out.println("Update Successful = "+result);
       session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
}
