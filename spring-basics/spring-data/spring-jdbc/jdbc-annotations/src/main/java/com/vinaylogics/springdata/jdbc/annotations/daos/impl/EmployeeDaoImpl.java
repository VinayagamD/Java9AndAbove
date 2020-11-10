package com.vinaylogics.springdata.jdbc.annotations.daos.impl;

import com.vinaylogics.springdata.jdbc.annotations.daos.EmployeeDao;
import com.vinaylogics.springdata.jdbc.annotations.models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int saveEmployee(Employee employee) {
        return jdbcTemplate.update(Q_SAVE, employee.getName(), employee.getSalary());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(Q_FIND_ALL, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong(C_ID));
            employee.setName(rs.getString(C_NAME));
            employee.setSalary(rs.getFloat(C_SALARY));
            return employee;
        });
    }
}
