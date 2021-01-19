package com.vinaylogics.hibernate_tutorial.hql.criteria_query;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.File;
import java.util.List;

class CriteriaQueryTest extends BaseTestClass {


    @Override
    protected File getFile() {
        return new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
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

    @Test
    @DisplayName("Test Demo Subqueries")
    public void testSubQueryDemo(){
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);

        // count books written by an author
        Subquery<Long> sub = cq.subquery(Long.class);
        Root<Book> subRoot = sub.from(Book.class);
        SetJoin<Book, Author> subAuthors = subRoot.joinSet(Book_.AUTHORS);
        sub.select(cb.count(subRoot.get(Book_.ID)));
        sub.where(cb.equal(root.get(Author_.ID), subAuthors.get(Book_.ID)));
        // check the result of the subquery
        cq.where(cb.greaterThanOrEqualTo(sub, 3L));

        TypedQuery<Author> query = session.createQuery(cq);
        query.getResultList().forEach(System.out::println);

        transaction.commit();
    }
}