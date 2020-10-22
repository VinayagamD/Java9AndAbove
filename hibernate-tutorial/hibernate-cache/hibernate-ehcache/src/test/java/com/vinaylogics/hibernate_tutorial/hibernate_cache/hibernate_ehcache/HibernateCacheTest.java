package com.vinaylogics.hibernate_tutorial.hibernate_cache.hibernate_ehcache;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hibernate_cache.hibernate_ehcache.models.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class HibernateCacheTest extends BaseTestClass {

    private Session otherSession;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        otherSession = sessionFactory.openSession();
    }

    @Override
    protected File getFile() {
        return new File(HibernateCacheTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Test
    public void testCaching(){
        Transaction transaction = session.beginTransaction();
        Transaction otherTransaction = otherSession.beginTransaction();
        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());

        Employee emp = session.load(Employee.class, 15L);
        printStats(stats, 0);



        emp =  session.load(Employee.class, 15L);
        printData(emp, stats, 2);

        //clear first level cache, so that second level cache is used
        session.evict(emp);
        emp = session.load(Employee.class, 15L);
        printData(emp, stats, 3);

        emp = session.load(Employee.class, 16L);
        printData(emp, stats, 4);

        emp =  otherSession.load(Employee.class, 16L);
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

    @Override
    @AfterEach
    public void tearDown() {
        otherSession.close();
        super.tearDown();
    }
}