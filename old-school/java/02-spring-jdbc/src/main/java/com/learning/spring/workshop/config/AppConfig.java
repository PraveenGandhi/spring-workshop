package com.learning.spring.workshop.config;


import com.learning.spring.workshop.dao.IStudentDAO;
import com.learning.spring.workshop.dao.StudentDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource
                ("jdbc:h2:file:./spring-workshop", "sa", "");
        dataSource.setDriverClassName("org.h2.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public IStudentDAO studentDAO(JdbcTemplate jdbcTemplate){
        return new StudentDAOImpl(jdbcTemplate);
    }
}