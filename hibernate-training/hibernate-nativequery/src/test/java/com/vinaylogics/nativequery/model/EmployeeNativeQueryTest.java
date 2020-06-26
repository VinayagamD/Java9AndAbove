package com.vinaylogics.nativequery.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@DisplayName("Employee NativeQuery Test")
class EmployeeNativeQueryTest {

    private SessionFactory sessionFactory;
    private Session session;

    @BeforeEach
    public void setUp(){
        File file = new File(Employee.class.getClassLoader().getResource("hibernate-native.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testSelectNativeQueryTest(){
        NativeQuery<Object[]> employeeQuery = session.createSQLQuery("SELECT * FROM employee");
        AtomicInteger i = new AtomicInteger();
        employeeQuery.list().forEach(rows ->{
            System.out.println("========================== Rows "+ i.getAndIncrement() +" ========================");
            Arrays.asList(rows).forEach(column -> System.out.print(column + " | "));

            System.out.println("\n==================================================================");
        });
    }

    @Test
    public void testSingleEntityQuery(){
        Query<Object[]>  namedQuery= session.createSQLQuery("SELECT * FROM employee WHERE id=:id").setParameter("id", 102);
        Arrays.asList(namedQuery.getSingleResult()).forEach(employee-> {
            System.out.print("| "+ employee +" |");
        });
    }

    @Test
    public void testSingleEntityQueryClassSpecific(){
        NativeQuery<Employee> employeeNativeQuery = session.createNativeQuery("SELECT * FROM employee", Employee.class);
        employeeNativeQuery.list().forEach(System.out::println);
    }

    @Test
    public void testNamedNativeQuery(){
       Query<Employee> nativeQuery = session.createNamedQuery("Employee.findall");
       nativeQuery.getResultList().forEach(System.out::println);
    }

    @Test
    public void testSingleEntityNamedQuery(){
       Query<Employee>  namedQuery= session.createNamedQuery("Employee.findById").setParameter("id", 102);
        System.out.println(namedQuery.getSingleResult());
    }

    @AfterEach
    public void tearDown(){
        session.close();
        sessionFactory.close();
    }
}