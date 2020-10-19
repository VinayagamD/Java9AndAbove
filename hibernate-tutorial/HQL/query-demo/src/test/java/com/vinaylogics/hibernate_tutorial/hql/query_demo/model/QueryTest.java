package com.vinaylogics.hibernate_tutorial.hql.query_demo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class QueryTest {

    File file;
    SessionFactory sessionFactory;
    Session session;

    @BeforeEach
    void setUp() {
        file = new File(QueryTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }
    @Test
    @DisplayName("To Demo FROM Clause")
    public void testFromClauseData(){
        Transaction t = session.beginTransaction();
        String hql = "FROM com.vinaylogics.hibernate_tutorial.hql.query_demo.model.Employee AS e";
        Query<Employee> query = session.createQuery(hql);

        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @Test
    @DisplayName("To demo SELECT Clause")
    public void testSelectClause(){
        Transaction t = session.beginTransaction();
        String hql = "SELECT e.firstName FROM com.vinaylogics.hibernate_tutorial.hql.query_demo.model.Employee AS e";
        Query<String> query = session.createQuery(hql);
        query.getResultList().stream().map(row->{
           Employee employee = new Employee();
           employee.setFirstName(row);
           return employee;
        }).collect(Collectors.toList()).forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @ParameterizedTest(name = "To select employee where id is {0}")
    @DisplayName("To Demo WHERE Clause")
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public void testWhereClause(int id){
        Transaction t = session.beginTransaction();
        String hql = "FROM com.vinaylogics.hibernate_tutorial.hql.query_demo.model.Employee AS e WHERE e.id = "+id;
        Query<Employee> query = session.createQuery(hql);

        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @ParameterizedTest(name=" ORDER By Field id")
    @DisplayName("Order By Field test")
    @ValueSource(strings = {"id", "firstName", "lastName"})
    public void testOrderByClause_ASC(String field){
        Transaction t = session.beginTransaction();
        String hql = "FROM com.vinaylogics.hibernate_tutorial.hql.query_demo.model.Employee AS e ORDER BY e."+field;
        Query<Employee> query = session.createQuery(hql);

        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @ParameterizedTest(name=" ORDER By Field id")
    @DisplayName("Order By Field test")
    @ValueSource(strings = {"id", "firstName", "lastName"})
    public void testOrderByClause_DESC(String field){
        Transaction t = session.beginTransaction();
        String hql = "FROM com.vinaylogics.hibernate_tutorial.hql.query_demo.model.Employee AS e ORDER BY e."+field+" DESC";
        Query<Employee> query = session.createQuery(hql);

        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @ParameterizedTest(name = "Named Parameter Test for id = {0}")
    @DisplayName("Named Parameter Test")
    @ValueSource(longs = {1,2,3,4,5,6,7,8,9,10})
    public void testNamedParameter(Long id){
        Transaction t = session.beginTransaction();
        String hql = "FROM Employee AS e WHERE e.id = :id";
        Query<Employee> query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Employee> employees = query.list();
        employees.forEach(System.out::println);

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @Test
    @DisplayName("Group By Clause demo")
    public void testGroupBy(){
        Transaction t = session.beginTransaction();
        String hql = "SELECT COUNT(e), e.firstName FROM Employee AS e GROUP BY e.firstName";
        Query<Object[]> query = session.createQuery(hql);
        List<Object[]> employees = query.list();
        employees.forEach(row->{
            Arrays.asList(row).forEach(System.out::println);
        });

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @Test
    @DisplayName("Test Aggregate functions demo")
    public void testAggregate(){
        Transaction t = session.beginTransaction();
        String hql = "SELECT COUNT(e), AVG(e.id), SUM(e.id), " +
                " MAX(e.id), MIN(e.id) FROM Employee AS e";
        Query<Object[]> query = session.createQuery(hql);
        List<Object[]> employees = query.list();
        employees.forEach(row->{
            Arrays.asList(row).forEach(System.out::println);
        });

        t.commit();
        System.out.println("Data Selection Successful");
    }

    @ParameterizedTest(name="Update name for id = {0}")
    @DisplayName("Demo For Update query")
    @ValueSource(longs = {19, 20})
    public void testForInsert(long id){
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Employee  e SET e.firstName = :name WHERE e.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("name","vinay");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result);
        t.commit();
        System.out.println("Data Update Successful");
    }

    @ParameterizedTest(name="Update name for id = {0}")
    @DisplayName("Demo For Delete query")
    @ValueSource(longs = {19, 20})
    public void testDeleteQuery(long id){
        Transaction t = session.beginTransaction();
        String hql = "DELETE Employee e WHERE e.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        System.out.println(result);
        t.commit();
        System.out.println("Data Update Successful");
    }

    @ParameterizedTest(name="Test Pagination for start position {0}")
    @DisplayName("Demo for pagination")
    @ValueSource(ints = {0,10})
    public void testForPagination(int startPosition){
        Transaction t = session.beginTransaction();
        String hql = "FROM Employee";
        Query<Employee> query = session.createQuery(hql);
        List<Employee> employees = query.setFirstResult(startPosition).setMaxResults(10).list();
        employees.forEach(System.out::println);
        t.commit();
        System.out.println("Data Pagination Successful");
    }



    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}