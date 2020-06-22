package org.vinaylogics.hibernatebasics.annotation.crieteriaquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinaylogics.hibernatebasics.annotation.crieteriaquery.model.MyEmployee;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Address;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Employee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;
import java.util.stream.IntStream;

public class EmployeeDataInsertCriteria {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataInsertCriteria.class.getClassLoader().getResource("hibernate_crietria.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            MyEmployee employee = new MyEmployee();
            employee.setFirstName(FIRST+"_"+i);
            employee.setLastName(LAST+"_"+i);
            session.save(employee);
        });
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
