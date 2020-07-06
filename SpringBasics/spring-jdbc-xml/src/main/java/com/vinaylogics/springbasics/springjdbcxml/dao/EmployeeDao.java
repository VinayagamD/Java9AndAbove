package com.vinaylogics.springbasics.springjdbcxml.dao;

import com.vinaylogics.springbasics.springjdbcxml.model.Employee;
import com.vinaylogics.springbasics.springjdbcxml.utils.QueryConstant;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao implements QueryConstant.TableEmployees {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int saveEmployee(Employee employee){
        return jdbcTemplate.update(Q_SAVE, employee.getName(), employee.getSalary());
     }
}
