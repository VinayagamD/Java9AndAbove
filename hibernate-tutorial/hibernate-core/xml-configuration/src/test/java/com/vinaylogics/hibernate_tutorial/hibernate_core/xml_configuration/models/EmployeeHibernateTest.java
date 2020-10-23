package com.vinaylogics.hibernate_tutorial.hibernate_core.xml_configuration.models;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeHibernateTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(EmployeeHibernateTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Test
    public void testLoadConfigurationAndCreateTable(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setId(119);
        employee.setFirstName("Bhuvana");
        employee.setLastName("Shree");
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
    }


}