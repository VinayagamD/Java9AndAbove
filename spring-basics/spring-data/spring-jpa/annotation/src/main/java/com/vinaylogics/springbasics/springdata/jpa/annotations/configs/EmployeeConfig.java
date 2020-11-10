package com.vinaylogics.springbasics.springdata.jpa.annotations.configs;

import com.mysql.cj.jdbc.Driver;
import com.vinaylogics.springbasics.springdata.jpa.annotations.daos.EmployeeDao;
import com.vinaylogics.springbasics.springdata.jpa.annotations.daos.impl.EmployeeDaoImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class EmployeeConfig {

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(Driver.class.getName());
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/jpa_employees");
        basicDataSource.setUsername("vinay");
        basicDataSource.setPassword("drago");
        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.vinaylogics.springbasics.springdata.jpa.annotations.models");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
                "hibernate.dialect", MySQL8Dialect.class.getName());
        hibernateProperties.setProperty("hibernate.show_sql", String.valueOf(true));
        hibernateProperties.setProperty("hibernate.format_sql", String.valueOf(true));
        return hibernateProperties;
    }

    @Bean(name = "edao")
    public EmployeeDao employeeDao(SessionFactory sessionFactory){
        return new EmployeeDaoImpl(sessionFactory);
    }
}
