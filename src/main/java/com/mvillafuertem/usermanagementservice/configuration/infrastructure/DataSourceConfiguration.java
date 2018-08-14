package com.mvillafuertem.usermanagementservice.configuration.infrastructure;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm")
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("infrastructure.relational.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
