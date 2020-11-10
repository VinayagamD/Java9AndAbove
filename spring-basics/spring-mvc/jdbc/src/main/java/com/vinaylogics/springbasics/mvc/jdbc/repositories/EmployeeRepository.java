package com.vinaylogics.springbasics.mvc.jdbc.repositories;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;
import com.vinaylogics.springbasics.mvc.jdbc.utils.QueryConstant;

import java.util.List;

public interface EmployeeRepository extends QueryConstant.TableEmployees {

    int saveEmployee(Employee employee);
    List<Employee>  findAll();
    Employee findById(int id);
}
