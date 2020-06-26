package com.vinaylogics.hibernate.criteria.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.File;

@DisplayName("Create test for the Entity Criteria Query")
class EmployeeCriteriaQueryTest {

    SessionFactory sessionFactory;
    Session session;

    @BeforeEach
    void setUp() {
        File file = new File(Employee.class.getClassLoader().getResource("hibernate-criteria.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @DisplayName("Test for Criteria Query Order By")
    @Test
    public void testCriteriaQueryOrderBy(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> from = cq.from(Employee.class);

        CriteriaQuery<Employee> query = cq.select(from).orderBy(cb.asc(from.get("firstName")),cb.desc(from.get("lastName")));
        TypedQuery<Employee> tq = session.createQuery(query);
        tq.getResultList().forEach(System.out::println);
    }


    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}