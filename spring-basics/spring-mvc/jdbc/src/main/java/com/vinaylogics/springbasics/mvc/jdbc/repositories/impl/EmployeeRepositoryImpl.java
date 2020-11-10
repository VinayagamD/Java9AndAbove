package com.vinaylogics.springbasics.mvc.jdbc.repositories.impl;

import com.vinaylogics.springbasics.mvc.jdbc.models.Employee;
import com.vinaylogics.springbasics.mvc.jdbc.repositories.EmployeeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    @Override
    public int saveEmployee(Employee employee) {
        return jdbcTemplate.update(Q_SAVE, employee.getName(), employee.getSalary());
    }

    @Override
    public List<Employee> findAll() {
        return  jdbcTemplate.query(Q_FIND_ALL, rs -> {
            List<Employee> employees = new ArrayList<>();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt(C_ID));
                employee.setName(rs.getString(C_NAME));
                employee.setSalary(rs.getFloat(C_SALARY));
                employees.add(employee);
            }
            return employees;
        });
    }

    @Override
    public Employee findById(int id) {
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("id",id);
        return namedJdbcTemplate.queryForObject(NQ_FIND_BY_ID, sqlParameterSource, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getInt(C_ID));
            employee.setName(rs.getString(C_NAME));
            employee.setSalary(rs.getFloat(C_SALARY));
            return employee;
        });
    }
}
