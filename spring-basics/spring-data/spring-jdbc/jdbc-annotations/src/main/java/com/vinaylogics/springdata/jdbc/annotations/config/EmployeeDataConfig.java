package com.vinaylogics.springdata.jdbc.annotations.config;

import com.vinaylogics.springdata.jdbc.annotations.daos.EmployeeDao;
import com.vinaylogics.springdata.jdbc.annotations.daos.impl.EmployeeDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class EmployeeDataConfig {

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_employees");
        dataSource.setUsername("vinay");
        dataSource.setPassword("drago");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean("edao")
    public EmployeeDao employeeDao(JdbcTemplate jdbcTemplate){
        return new EmployeeDaoImpl(jdbcTemplate);
    }

}
