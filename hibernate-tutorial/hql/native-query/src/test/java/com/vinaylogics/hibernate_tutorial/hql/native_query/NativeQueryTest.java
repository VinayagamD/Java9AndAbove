package com.vinaylogics.hibernate_tutorial.hql.native_query;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.native_query.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class NativeQueryTest extends BaseTestClass {


    @Override
    protected File getFile() {
        return new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }


    @Test
    @DisplayName("Test Native Query To Select All")
    public void testNativeQueryToSelectAll(){
        NativeQuery<Object[]> employeeQuery = session.createSQLQuery("SELECT * FROM employee");
        AtomicInteger i = new AtomicInteger();
        employeeQuery.list().forEach(rows ->{
            System.out.println("========================== Rows "+ i.getAndIncrement() +" ========================");
            Arrays.asList(rows).forEach(column -> System.out.print(column + " | "));

            System.out.println("\n==================================================================");
        });
    }

    @ParameterizedTest(name = "Select Employee Based On id ={0}")
    @ValueSource(longs = {1,2,3,4,5})
    public void testNativeQueryToSelectBasedOnId(Long id){
        Query<Object[]> nativeQuery= session.createSQLQuery("SELECT * FROM employee WHERE id=:id").setParameter("id", id);
        Arrays.asList(nativeQuery.getSingleResult()).forEach(employee-> {
            System.out.print("| "+ employee +" |");
        });
    }

    @Test
    @DisplayName("Test Native Query Specific to class")
    public void testNativeQuerySpecificToClass(){
        NativeQuery<Employee> employeeNativeQuery = session.createNativeQuery("SELECT * FROM employee", Employee.class);
        employeeNativeQuery.list().forEach(System.out::println);
    }

}