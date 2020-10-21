package com.vinaylogics.hibernate_tutorial.hql.stored_procedure;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class StoredProcedureTest extends BaseTestClass {


    @Override
    protected File getFile() {
        return new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }

    @Test
    @DisplayName("Test Stored Procedure Find All Employee")
    public void testFindAllEmployee(){
        StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery("get_all_employee");
        storedProcedureQuery.execute();
        AtomicInteger integer = new AtomicInteger(0);
        ((List<Object[]>)storedProcedureQuery.getResultList()).forEach(rows-> {
            System.out.println("=========================== rows "+ integer.getAndIncrement()+ " =========================");
            Arrays.asList(rows).forEach(column-> System.out.print(" | " + column+ " | "));
            System.out.println("\n=======================================================");
        });
    }

    @ParameterizedTest(name = "Stored Procedure Find Employee With Id = {0}")
    @ValueSource(longs = {1,2,3,4,5,6})
    public void testFindEmployeeById(Long id){
        ProcedureCall call = session.createStoredProcedureCall("find_employee_by_id");
        call.registerParameter(1, Long.class, ParameterMode.IN).bindValue(id);
        Output output = call.getOutputs().getCurrent();
        List<Object[]> records = ((ResultSetOutput) output).getResultList();
        records.forEach(record -> {
            Arrays.asList(record).forEach(column->{
                System.out.print(" | " + column + " | ");
            });
        });
    }

    @Test
    @DisplayName("Store Procedure Find Employee Count")
    public void testGetEmployeeCount(){
        StoredProcedureQuery query = session.createStoredProcedureQuery("get_employee_count")
                .registerStoredProcedureParameter("count", Integer.class, ParameterMode.OUT);
        query.execute();
        System.out.println(query.getOutputParameterValue("count"));
    }

    @Test
    @DisplayName("Test Named Stored Procedure Find All Employee")
    public void testNamedFindAllEmployee(){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.findAll");
        storedProcedureQuery.execute();
        storedProcedureQuery.getResultList().forEach(System.out::println);
    }


    @ParameterizedTest(name = "Stored Procedure Named Find Employee With Id = {0}")
    @ValueSource(longs = {1,2,3,4,5,6})
    public void testNamedFindEmployeeById(Long id){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.findById")
                .setParameter("id", id);
        storedProcedureQuery.getResultList().forEach(System.out::println);
    }

    @Test
    @DisplayName(" Named Store Procedure Find Employee Count")
    public void testNamedGetEmployeeCount(){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.count");
        storedProcedureQuery.execute();
        System.out.println(storedProcedureQuery.getOutputParameterValue("count"));
    }

}