package com.vinaylogics.hibernate_tutorial.hql.criteria_query;

import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Address;
import com.vinaylogics.hibernate_tutorial.hql.criteria_query.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.stream.IntStream;

class DataGeneratorTest {
    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56000";
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
    public void testGenerateData(){
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            Employee employee = new Employee();
            employee.setFirstName(FIRST+"_"+i);
            employee.setLastName(LAST+"_"+i);
            Address address = new Address();
            address.setCity(CITY);
            address.setCountry(COUNTRY);
            address.setPinCode(Integer.parseInt(PIN_CODE + (i < 10 ? "8"+i :  i)));
            employee.setAddress(address);
            session.save(employee);
        });
        t.commit();
        System.out.println("Data Generation Successful");
    }

    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}