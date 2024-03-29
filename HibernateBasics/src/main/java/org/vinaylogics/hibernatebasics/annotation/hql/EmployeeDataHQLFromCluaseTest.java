package org.vinaylogics.hibernatebasics.annotation.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinaylogics.hibernatebasics.annotation.hql.models.HqlEmployee;

import java.io.File;

public class EmployeeDataHQLFromCluaseTest {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataHQLFromCluaseTest.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        String hql  = "FROM Employee";
        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.HqlEmployee";
        Query<HqlEmployee> query = session.createQuery(hql);
        query.list().forEach(System.out::println);
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
