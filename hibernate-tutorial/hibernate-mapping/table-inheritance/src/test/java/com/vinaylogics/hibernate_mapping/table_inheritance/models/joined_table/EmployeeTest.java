package com.vinaylogics.hibernate_mapping.table_inheritance.models.joined_table;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(EmployeeTest.class.getClassLoader().getResource("hibernate_im_jt.cfg.xml").getFile());
    }

    @Test
    public void testPermanentEmployee(){
        Transaction t = session.beginTransaction();
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        permanentEmployee.setEmployeeId(UUID.randomUUID().toString());
        permanentEmployee.setFirstName("Meiyappan");
        permanentEmployee.setLastName("Student");
        permanentEmployee.setCostCenter("Besant");
        permanentEmployee.setTotalLeaves(10.0f);
        permanentEmployee.setStartDate(LocalDate.now());
        session.save(permanentEmployee);
        t.commit();
        System.out.println("Save Successful");
    }

    @Test
    public void testContractEmployee(){
        Transaction t = session.beginTransaction();
        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setEmployeeId(UUID.randomUUID().toString());
        contractEmployee.setFirstName("Meiyappan");
        contractEmployee.setLastName("Student");
        contractEmployee.setContractEndDate(LocalDate.now());
        contractEmployee.setContractStartDate(LocalDate.now());
        contractEmployee.setAgencyName("Besant");
        session.save(contractEmployee);
        t.commit();
        System.out.println("Save Successful");
    }

}