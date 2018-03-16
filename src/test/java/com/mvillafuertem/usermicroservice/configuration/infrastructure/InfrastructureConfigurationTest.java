package com.mvillafuertem.usermicroservice.configuration.infrastructure;

import com.mvillafuertem.usermicroservice.configuration.environment.Develop;
import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.infrastructure.mapper.Mapper;
import com.mvillafuertem.usermicroservice.infrastructure.mapper.ToDomain;
import com.mvillafuertem.usermicroservice.infrastructure.model.UserDBO;
import com.mvillafuertem.usermicroservice.infrastructure.repository.UserRepository;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@Develop
@Configuration
public class InfrastructureConfigurationTest {

    @Bean
    public UserRepository userRepository() {
        return mock(UserRepository.class);
    }

    @Bean
    public ToDomain<UserDBO, User> mapper() {
        return mock(Mapper.class);
    }
}