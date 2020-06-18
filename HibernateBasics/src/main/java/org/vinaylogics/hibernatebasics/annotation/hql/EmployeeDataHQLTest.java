package org.vinaylogics.hibernatebasics.annotation.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Address;
import org.vinaylogics.hibernatebasics.annotation.hql.models.Employee;


import java.io.File;
import java.util.stream.IntStream;

public class EmployeeDataHQLTest {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56008";

    public static void main(String[] args) {
        File file = new File(EmployeeDataHQLTest.class.getClassLoader().getResource("hibernate_hql.cfg.xml").getFile());
        SessionFactory sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            Employee employee = new Employee();
            employee.setFirstName(FIRST+"_"+i);
            employee.setLastName(LAST+"_"+i);
            Address address = new Address();
            address.setCity(CITY);
            address.setCountry(COUNTRY);
            address.setPincode(Integer.parseInt(PIN_CODE+i));
            employee.setAddress(address);
            session.save(employee);
        });
        t.commit();
        System.out.println("Save Successful");
        sessionFactory.close();
        session.close();
    }
}
