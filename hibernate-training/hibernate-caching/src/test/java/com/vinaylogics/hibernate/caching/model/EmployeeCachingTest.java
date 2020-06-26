package com.vinaylogics.hibernate.caching.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("To test Employee entity for second level caching")
class EmployeeCachingTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Session otherSession;

    @BeforeEach
    void setUp() {
        File file = new File(Employee.class.getClassLoader().getResource("hibernate-cache.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
        session = sessionFactory.openSession();
        otherSession = sessionFactory.openSession();
    }

    @Test
    public void testCreateCaching(){
        Transaction transaction = session.beginTransaction();
        Transaction otherTransaction = otherSession.beginTransaction();
        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());

        Employee emp = session.load(Employee.class, 63);
        printStats(stats, 0);



        emp =  session.load(Employee.class, 63);
        printData(emp, stats, 2);

        //clear first level cache, so that second level cache is used
        session.evict(emp);
        emp = session.load(Employee.class, 63);
        printData(emp, stats, 3);

        emp = session.load(Employee.class, 64);
        printData(emp, stats, 4);

        emp =  otherSession.load(Employee.class, 64);
        printData(emp, stats, 5);

        //Release resources
        transaction.commit();
        otherTransaction.commit();
    }
    private  void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("Second Level Miss Count="
                        + stats
                        .getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }

    private  void printData(Employee emp, Statistics stats, int count) {
        System.out.println(count+"::" + emp);
        printStats(stats, count);
    }


    @AfterEach
    void tearDown() {
        session.close();
        otherSession.close();
        sessionFactory.close();
    }
}