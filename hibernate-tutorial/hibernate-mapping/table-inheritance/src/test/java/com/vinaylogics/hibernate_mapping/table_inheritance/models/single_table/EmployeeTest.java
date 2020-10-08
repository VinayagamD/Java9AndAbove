package com.vinaylogics.hibernate_mapping.table_inheritance.models.single_table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    File file;
    SessionFactory sessionFactory;
    Session session;
    @BeforeEach
    void setUp() {
        file = new File(EmployeeTest.class.getClassLoader().getResource("hibernate_im_st.cfg.xml").getFile());
        sessionFactory = new Configuration().configure(file)
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testPermanentEmployee(){
        Transaction t = session.beginTransaction();
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        permanentEmployee.setFirstName("Meiyappan");
        permanentEmployee.setLastName("Student");
        permanentEmployee.setCostCenter("Besant");
        permanentEmployee.setLocalDate(LocalDate.now());
        permanentEmployee.setTotalLeaves("1000");
        session.save(permanentEmployee);
        t.commit();
        System.out.println("Save Successful");
    }

    @Test
    public void testContractEmployee(){
        Transaction t = session.beginTransaction();
        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setFirstName("Meiyappan");
        contractEmployee.setLastName("Student");
        contractEmployee.setContractEndDate(LocalDate.now());
        contractEmployee.setContractEndDate(LocalDate.now());
        contractEmployee.setAgencyName("Besant");
        session.save(contractEmployee);
        t.commit();
        System.out.println("Save Successful");
    }
    @AfterEach
    void tearDown() {
        session.close();
        sessionFactory.close();
    }
}