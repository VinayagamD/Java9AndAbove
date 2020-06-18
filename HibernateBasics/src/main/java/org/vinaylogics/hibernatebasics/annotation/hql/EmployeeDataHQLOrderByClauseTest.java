package org.vinaylogics.hibernatebasics.annotation.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Employee;

import java.io.File;
import java.util.List;

public class EmployeeDataHQLOrderByClauseTest {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataHQLOrderByClauseTest.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql  = " FROM Employee AS e WHERE e.id > 50  ORDER BY e.firstName DESC";
//        String hql  = " FROM Employee AS e WHERE e.id > 50  ORDER BY e.firstName ";
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        Query<Employee> query = session.createQuery(hql);
        List<Employee> rows = query.list();
        rows.forEach(System.out::println);
        /*   *//* for (Object[] row: rows) {*//*
            for (Object col: rows){
                System.out.println(col);
            }
        *//*}*/
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
