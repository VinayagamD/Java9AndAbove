package com.vinaylogics.hibernate_tutorial.hibernate_core.annotation_configuration.models;

import com.mysql.cj.xdevapi.AddResult;
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
    public void testHibernateAnnotation_Save(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Veilu");
        employee.setLastName("Kantha");
        Address address = new Address();
        address.setCity("Bangalore");
        address.setCountry("India");
        address.setPinCode(560001);
        employee.setAddress(address);
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
    }
}