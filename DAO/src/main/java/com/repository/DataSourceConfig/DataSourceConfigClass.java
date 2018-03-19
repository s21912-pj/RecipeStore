package com.repository.DataSourceConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.repository.impl"},excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class DataSourceConfigClass {

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource getDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource);
        return jdbcTemplate;
    }
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/testdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;

    }
}
