package com.vinaylogics.hibernate_mapping.table_inheritance.models.single_table;

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

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(EmployeeTest.class.getClassLoader().getResource("hibernate_im_st.cfg.xml").getFile());
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
        contractEmployee.setContractStartDate(LocalDate.now());
        contractEmployee.setContractEndDate(LocalDate.now());
        contractEmployee.setAgencyName("Besant");
        session.save(contractEmployee);
        t.commit();
        System.out.println("Save Successful");
    }
}