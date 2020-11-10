package com.vinayalogics.hibernate_tutorial.hql.hibernate_methods;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.hibernate_methods.model.Address;
import com.vinaylogics.hibernate_tutorial.hql.hibernate_methods.model.Employee;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.stream.IntStream;

class DataGenerateTest  extends BaseTestClass {
    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";
    public static final String ADDRESS = EMPLOYEE + "_Address";
    public static final String CITY = "Bangalore";
    public static final String COUNTRY = "India";
    public static final String PIN_CODE = "56000";

    @Override
    protected File getFile() {
        return new File(DataGenerateTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
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

}