package com.vinayalogics.hibernate_tutorial.hql.hibernate_methods;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.hibernate_methods.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HibernateMethodTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(DataGenerateTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }


    @Test
    @DisplayName("Test Get All Records")
    public void testGetAllRecords(){
        session.createQuery("FROM Employee e", Employee.class)
                .list().forEach(System.out::println);
    }

    @ParameterizedTest(name = "Getting Employee With Id {0}")
    @ValueSource(longs = {1,2,3,4,5,6,7})
    public void testGetSingleRow(long id){
        Employee employee = session.get(Employee.class, id);
        System.out.println(employee);
        System.out.println("Get Single Row Successful");
    }

    @ParameterizedTest(name = "Getting Employee With non existing Id {0}")
    @ValueSource(longs = {21,22,23,24,25,26,27})
    public void testGetSingleRow_nonExistingId(long id){
        Employee employee = session.get(Employee.class, id);
        System.out.println(employee);
        System.out.println("Get Single Row Successful");
    }

    @ParameterizedTest(name = "Loading Employee With Id {0}")
    @ValueSource(longs = {1,2,3,4,5,6,7})
    public void testLoadSingleRow(long id){
        Employee employee = session.load(Employee.class, id);
        System.out.println(employee);
        System.out.println("Get Single Row Successful");
    }

    @ParameterizedTest(name = "Loading Employee With non existing Id {0}")
    @ValueSource(longs = {21,22,23,24,25,26,27})
    public void testLoadSingleRow_nonExistingId(long id){
        try {
            Employee employee = session.load(Employee.class, id);
            System.out.println(employee);
            System.out.println("Get Single Row Successful");
            fail("Expecting Exception");
        } catch (Exception e) {
            assertNotNull(e);
            System.out.println(e.getMessage());
        }
    }

    @ParameterizedTest(name = "Updating Employee With Id {0}")
    @ValueSource(longs = {15,16,17,18,19,20})
    public void testUpdateEmployee(long id){
        Employee employee = session.get(Employee.class, id);
        System.out.println(employee);
        System.out.println("Get Single Row Successful");
        Transaction transaction = session.beginTransaction();
        employee.setFirstName("Update_First_Name "+id);
        employee.setLastName("Update_Last_Name "+id);
        session.update(employee);
        transaction.commit();
    }


    @ParameterizedTest(name = "Deleting Employee With Id {0}")
    @ValueSource(longs = {15,16,17,18,19,20})
    public void testDeleteEmployee(long id){
        Employee employee = session.get(Employee.class, id);
        System.out.println(employee);
        System.out.println("Get Single Row Successful");
        Transaction transaction = session.beginTransaction();
        session.delete(employee);
        transaction.commit();
    }

}