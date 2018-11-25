package com.community.apiservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigurer
{


    @Primary//主数据源注解
    @Bean(name = "masterDataSourceProperties")
    @Qualifier("masterDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary//主数据源注解
    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return masterDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "bookDataSourceProperties")
    @Qualifier("bookDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.book")
    public DataSourceProperties bookDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "bookDataSource")
    @Qualifier("bookDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.book")
    public DataSource bookDataSource() {
        return bookDataSourceProperties().initializeDataSourceBuilder().build();
    }


}