package com.vinaylogics.springdata.jdbc.xml.doas;

import com.vinaylogics.springdata.jdbc.xml.models.Employee;
import com.vinaylogics.springdata.jdbc.xml.utils.QueryConstant;

import java.util.List;

public interface EmployeeDao extends QueryConstant.EmployeeTable {
    int saveEmployee(Employee employee);

    List<Employee> findAll();
}
