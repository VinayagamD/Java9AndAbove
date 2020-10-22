package com.vinaylogics.hibernate_tutorial.hibernate_batch_transaction.models;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BatchInsertTest extends BaseTestClass {

    public static final String EMPLOYEE = "Employee";
    public static final String FIRST = EMPLOYEE + "_First";
    public static final String LAST = EMPLOYEE + "_Last";

    @Override
    protected File getFile() {
        return new File(BatchInsertTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Test
    public void testBatchInsertData() {
        Transaction t = session.beginTransaction();
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Employee employee = new Employee();
            employee.setFirstName(FIRST + "_" + i);
            employee.setLastName(LAST + "_" + i);
            session.save(employee);
            if(i % 20 == 0){
                session.flush();
                session.clear();
            }

        });
        t.commit();
        System.out.println("Data Generation Successful");

    }
}