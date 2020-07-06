package com.vinaylogics.springbasics.springjdbcannotations.dao;


import com.vinaylogics.springbasics.springjdbcannotations.models.Employee;
import com.vinaylogics.springbasics.springjdbcannotations.utils.QueryConstant;
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
