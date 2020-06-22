package org.vinaylogics.hibernatebasics.annotation.crieteriaquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Employee;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.File;

public class EmployeeDataNarrowCriteria2RestrictionResult {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataNarrowCriteria2RestrictionResult.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
//        String hql  = "FROM org.vinaylogics.hibernatebasics.annotation.hql.models.Employee AS e";
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        ParameterExpression<Integer> q = cb.parameter(Integer.class);
        Predicate predicateLessThan = cb.ge(root.get("id"),40 );
        Predicate predicateForRedColor = cb.le(root.get("id"), 50);
        CriteriaQuery<Employee> select = cr.select(root).where(cb.and(predicateLessThan, predicateForRedColor));
        TypedQuery<Employee> typedQuery = session.createQuery(select);
        typedQuery.getResultList().forEach(System.out::println);
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
