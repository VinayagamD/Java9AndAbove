package com.vinaylogics.springbasics.springmvcdemo.repositories;

import com.vinaylogics.springbasics.springmvcdemo.models.Employee;
import com.vinaylogics.springbasics.springmvcdemo.utils.QueryConstant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository implements QueryConstant.TableEmployees {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedJdbcTemplate;


    public EmployeeRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    public int saveEmployee(Employee employee){
        return jdbcTemplate.update(Q_SAVE, employee.getName(), employee.getSalary());
    }

    public List<Employee> getEmployees(){
        return jdbcTemplate.query(Q_FIND_ALL, rs -> {
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

    public Employee getEmployeeById(int id){
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
