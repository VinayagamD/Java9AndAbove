package com.vinaylogics.hibernate.storedprocedure.model;

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

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@DisplayName("Testing Employee Stored Procedure")
class EmployeeStoredProcedureTest {

    private SessionFactory sessionFactory;
    private Session session;

    @BeforeEach
    public void setUp(){
        File file = new File(Employee.class.getClassLoader().getResource("hibernate-sp.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file).buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @DisplayName("Name Unit Test Check Up")
    @Test
    public void startTest(){
        System.out.println("Running Test");
    }

    @DisplayName("Call Stored Procedure Get All Employee")
    @Test
    public void testGetAllEmployeeStoreProcedure(){
        StoredProcedureQuery storedProcedureQuery = session.createStoredProcedureQuery("get_all_employee");
        storedProcedureQuery.execute();
        AtomicInteger integer = new AtomicInteger(0);
        ((List<Object[]>)storedProcedureQuery.getResultList()).forEach(rows-> {
            System.out.println("=========================== rows "+ integer.getAndIncrement()+ " =========================");
            Arrays.asList(rows).forEach(column-> System.out.print(" | " + column+ " | "));
            System.out.println("\n=======================================================");
        });
    }

    @DisplayName("Test Get Named Stored Procedure call")
    @Test
    public void testGetNamedStoredProcedure(){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.findAll");
        storedProcedureQuery.execute();
        storedProcedureQuery.getResultList().forEach(System.out::println);
    }


    @DisplayName("Call Stored Procedure Get Single Employee")
    @Test
    public void testGetSingleEmployeeStoreProcedure(){
        ProcedureCall call = session.createStoredProcedureCall("find_employee_by_id");
        call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(82);
        Output output = call.getOutputs().getCurrent();
        List<Object[]> records = ((ResultSetOutput) output).getResultList();
        records.forEach(record -> {
            Arrays.asList(record).forEach(column->{
                System.out.print(" | " + column + " | ");
            });
        });
    }

    @DisplayName("Call Stored Procedure Get Employee Count")
    @Test
    public void testGetEmployeeCountStoreProcedure(){
        StoredProcedureQuery query = session.createStoredProcedureQuery("get_employee_count")
                .registerStoredProcedureParameter("count", Integer.class, ParameterMode.OUT);
        query.execute();
        System.out.println(query.getOutputParameterValue("count"));
    }


    @DisplayName("Test Get Single Named Stored Procedure call")
    @Test
    public void testGetNamedSingleStoredProcedure(){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.findById")
                .setParameter("id", 101);
        storedProcedureQuery.getResultList().forEach(System.out::println);

    }

    @DisplayName("Test Get Employee Count")
    @Test
    public void testGetNamedEmployeeCountStoredProcedure(){
        StoredProcedureQuery storedProcedureQuery = session.createNamedStoredProcedureQuery("Employee.count");
        storedProcedureQuery.execute();
        System.out.println(storedProcedureQuery.getOutputParameterValue("count"));

    }

    @AfterEach
    public void tearDown(){
        session.close();
        sessionFactory.close();
    }

}