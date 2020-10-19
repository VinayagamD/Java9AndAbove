package org.vinaylogics.hibernatebasics.annotation.crieteriaquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.vinaylogics.hibernatebasics.annotation.hql.models.HqlEmployee;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;

public class EmployeeDataCreateCriteria {


    public static void main(String[] args) {
        File file = new File(EmployeeDataCreateCriteria.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<HqlEmployee> cr = cb.createQuery(HqlEmployee.class);
        Root<HqlEmployee> root = cr.from(HqlEmployee.class);
        cr.select(root);
        Query<HqlEmployee> rows = session.createQuery(cr);
        rows.list().forEach(System.out::println);
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
