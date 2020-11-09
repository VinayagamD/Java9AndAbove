package com.vinaylogics.springbasics.data.jpa.xml.daos;


import com.vinaylogics.springbasics.data.jpa.xml.models.Employee;

import java.util.List;

public interface EmployeeDao{
    Employee saveEmployee(Employee employee);

    List<Employee> findAll();
}
