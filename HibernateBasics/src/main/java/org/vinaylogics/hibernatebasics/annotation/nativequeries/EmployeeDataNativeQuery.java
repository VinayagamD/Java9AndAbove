package org.vinaylogics.hibernatebasics.annotation.nativequeries;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinaylogics.hibernatebasics.annotation.crieteriaquery.EmployeeDataCreateCriteria;
import org.vinaylogics.hibernatebasics.annotation.nativequeries.models.CMyEmployee;

import java.io.File;
import java.util.List;

public class EmployeeDataNativeQuery {



    public static void main(String[] args) {
        File file = new File(EmployeeDataCreateCriteria.class.getClassLoader().getResource("hibernate_native.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        Query query = session.getNamedQuery("Employee.findall");
        List<CMyEmployee> employees = query.list();
        employees.forEach(System.out::println);
transaction.commit();

        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
