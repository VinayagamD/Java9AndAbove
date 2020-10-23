package com.vinaylogics.hibernate_tutorial.hibernate_core.configuration_properties;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hibernate_core.configuration_properties.models.Address;
import com.vinaylogics.hibernate_tutorial.hibernate_core.configuration_properties.models.Employee;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationPropertiesTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(ConfigurationPropertiesTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Override
    protected ConfigType getConfigType() {
        return ConfigType.PROPERTIES;
    }

    @BeforeEach
    public void setUp() {
        loadProperties(ConfigurationPropertiesTest.class.getClassLoader().getResourceAsStream("databaseconfig.properties"));
        super.setUp();
    }

    @Test
    public void testHibernateAnnotation_Save(){
        Transaction t = session.beginTransaction();
        Employee employee = new Employee();
        employee.setFirstName("Meiyappan");
        employee.setLastName("Franco");
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