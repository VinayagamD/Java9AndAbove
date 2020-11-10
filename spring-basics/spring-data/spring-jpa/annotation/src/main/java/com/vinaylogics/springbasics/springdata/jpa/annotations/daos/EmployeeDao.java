package com.vinaylogics.springbasics.springdata.jpa.annotations.daos;




import com.vinaylogics.springbasics.springdata.jpa.annotations.models.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee saveEmployee(Employee employee);

    List<Employee> findAll();
}
