package com.vinaylogics.springbasics.springjdbcannotations.dao;


import com.vinaylogics.springbasics.springjdbcannotations.models.Employee;
import com.vinaylogics.springbasics.springjdbcannotations.utils.QueryConstant;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDao implements QueryConstant.TableEmployees {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int saveEmployee(Employee employee){
        return jdbcTemplate.update(Q_SAVE, employee.getName(), employee.getSalary());
    }

    public List<Employee> findAll(){
        return jdbcTemplate.query(Q_FIND_ALL, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt(EmployeeDao.C_ID));
            employee.setName(rs.getString(EmployeeDao.C_NAME));
            employee.setSalary(rs.getFloat(EmployeeDao.C_SALARY));
            return employee;
        });
    }

}
