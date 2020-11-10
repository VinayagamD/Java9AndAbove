package com.vinaylogics.springdata.jdbc.annotations.daos;


import com.vinaylogics.springdata.jdbc.annotations.models.Employee;
import com.vinaylogics.springdata.jdbc.annotations.utils.QueryConstant;

import java.util.List;

public interface EmployeeDao extends QueryConstant.EmployeeTable {
    int saveEmployee(Employee employee);

    List<Employee> findAll();
}
