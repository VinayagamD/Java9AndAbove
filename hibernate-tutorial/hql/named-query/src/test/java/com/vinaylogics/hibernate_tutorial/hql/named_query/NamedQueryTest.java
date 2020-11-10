package com.vinaylogics.hibernate_tutorial.hql.named_query;

import com.vinaylogics.hibernate_tutorial.core_test_module.base_test_class.BaseTestClass;
import com.vinaylogics.hibernate_tutorial.hql.named_query.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.TypedQuery;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class NamedQueryTest extends BaseTestClass {

    @Override
    protected File getFile() {
        return new File(DataGeneratorTest.class.getClassLoader().getResource("hibernate.cfg.xml").getFile());
    }


    @Test
    @DisplayName("To Test Name Query Find All")
    public void testNamedQueryFindAll(){
      TypedQuery<Employee> query = session.createNamedQuery("Employee.findAll", Employee.class);
      query.getResultList().forEach(System.out::println);
    }

    @ParameterizedTest(name = "Named Query For Employees with id = {0}")
    @DisplayName("To Test Name Query Find All")
    @ValueSource(longs = {1,2,3,4,5})
    public void testNamedQueryFindById(Long id){
      TypedQuery<Employee> query = session.createNamedQuery("Employee.findById", Employee.class).setParameter("id", id);
        System.out.println(query.getSingleResult());
    }

}