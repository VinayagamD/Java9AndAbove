package com.vinaylogics.hibernate_mapping.table_inheritance.models.mapped_super_class;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

class EmployeeTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(EmployeeTest.class.getClassLoader().getResource("hibernate_im_msc.cfg.xml").getFile());
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