package org.vinaylogics.hibernatebasics.annotation.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;

public class EmployeeHQLDeleteEmployee {


    public static void main(String[] args) {
        File file = new File(EmployeeHQLDeleteEmployee.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql  = " DELETE Employee e WHERE e.id= :id";
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        Query query = session.createQuery(hql);
        query.setParameter("id", 61);
        int result = query.executeUpdate();
        System.out.println("Delete Successful = "+result);
       session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
}
