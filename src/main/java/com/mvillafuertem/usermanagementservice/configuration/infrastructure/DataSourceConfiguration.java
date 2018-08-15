package com.mvillafuertem.usermanagementservice.configuration.infrastructure;


import com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm.UserRepositoryRelationalMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm")
public class DataSourceConfiguration {

    private static final String USER_DATA_SOURCE = "userDataSource";

    private static final String USER_SESSION_FACTORY = "userSessionFactory";

    @Bean(USER_DATA_SOURCE)
    @ConfigurationProperties("infrastructure.relational.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(USER_SESSION_FACTORY)
    public SqlSessionFactoryBean sqlSessionFactory(
            @Qualifier(USER_DATA_SOURCE) final DataSource dataSource) throws Exception {

        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        final SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().addMapper(UserRepositoryRelationalMapper.class);

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperFactoryBean<UserRepositoryRelationalMapper> lockRelationalMapper(
            @Qualifier(USER_SESSION_FACTORY) final SqlSessionFactoryBean sqlSessionFactory) throws Exception {

        final MapperFactoryBean<UserRepositoryRelationalMapper> factoryBean = new MapperFactoryBean<>(UserRepositoryRelationalMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory.getObject());

        return factoryBean;
    }
}
