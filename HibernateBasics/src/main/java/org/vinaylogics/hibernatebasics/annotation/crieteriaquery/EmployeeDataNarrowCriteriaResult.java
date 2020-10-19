package org.vinaylogics.hibernatebasics.annotation.crieteriaquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.hql.models.HqlEmployee;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;

public class EmployeeDataNarrowCriteriaResult {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataNarrowCriteriaResult.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<HqlEmployee> cr = cb.createQuery(HqlEmployee.class);
        Root<HqlEmployee> root = cr.from(HqlEmployee.class);
        CriteriaQuery<HqlEmployee> select = cr.select(root);
        TypedQuery<HqlEmployee> typedQuery = session.createQuery(select);
        typedQuery.setFirstResult(20);
        typedQuery.setMaxResults(10);
        typedQuery.getResultList().forEach(System.out::println);
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
