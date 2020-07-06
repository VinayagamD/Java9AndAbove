package com.vinaylogics.springbasics.springjdbcannotations.configs;

import com.vinaylogics.springbasics.springjdbcannotations.dao.EmployeeDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCConfigs {

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("vinay");
        dataSource.setPassword("drago");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_employees");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public EmployeeDao employeeDao(JdbcTemplate jdbcTemplate){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setJdbcTemplate(jdbcTemplate);
        return employeeDao;
    }
}
