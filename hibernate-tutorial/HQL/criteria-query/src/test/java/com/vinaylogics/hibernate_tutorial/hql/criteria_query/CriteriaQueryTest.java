package com.vinaylogics.hibernate_tutorial.hql.criteria_query;

import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;

class CriteriaQueryTest {

    File file;
    SessionFactory sessionFactory;
    Session session;

    @BeforeEach
    void setUp() {
        file = new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testCreateCriteriaQuery(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(root);
        Query<Employee> rows = session.createQuery(cr);
        rows.list().forEach(System.out::println);
        System.out.println("Criteria Successful");
    }

    @Test
    public void testNarrowResultCriteriaQuery(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(root);
        Predicate predicateGreaterThan = cb.ge(root.get("id"), 10);
        Predicate predicateLessThan = cb.le(root.get("id"), 15);
        CriteriaQuery<Employee> select = cr.select(root).where(cb.and(predicateGreaterThan, predicateLessThan));
        TypedQuery<Employee>  typedQuery = session.createQuery(select);
        typedQuery.getResultList().forEach(System.out::println);
        System.out.println("Criteria Successful");
    }

    @Test
    public void testNarrowResultCriteriaQuery2(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(root);
        CriteriaQuery<Employee> select = cr.select(root);
        TypedQuery<Employee>  typedQuery = session.createQuery(select);
        typedQuery.setFirstResult(10);
        typedQuery.setMaxResults(5);
        typedQuery.getResultList().forEach(System.out::println);
        System.out.println("Criteria Successful");
    }

    @Test
    public void testOrderByUsingCriteria(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
        Root<Employee> root = cr.from(Employee.class);
        cr.select(root);
        CriteriaQuery<Employee> orderById  = cr.orderBy(cb.desc(root.get("id")));
        TypedQuery<Employee>  typedQuery = session.createQuery(orderById);
        typedQuery.getResultList().forEach(System.out::println);
        System.out.println("Criteria Successful");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}