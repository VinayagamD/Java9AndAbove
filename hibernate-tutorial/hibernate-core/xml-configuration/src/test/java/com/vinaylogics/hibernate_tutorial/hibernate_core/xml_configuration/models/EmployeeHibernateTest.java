package com.vinaylogics.hibernate_tutorial.hibernate_core.xml_configuration.models;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

class EmployeeHibernateTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(Objects.requireNonNull(EmployeeHibernateTest.class.getClassLoader().getResource("hibernate.cfg.xml")).getFile());
    }

    @Test
    public void testLoadConfigurationAndCreateTable(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Sonal");
        employee.setLastName("Sarkaar");
        session.save(employee);
        t.commit();
        System.out.println("Save Successful");
    }


}