package com.mvillafuertem.usermanagementservice.configuration.infrastructure;

import com.mvillafuertem.usermanagementservice.configuration.environment.Develop;
import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.InfrastructureToDomain;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.MapperInfrastructure;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.MongoDBUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Develop
@Configuration
public class InfrastructureTestConfiguration {

    @Bean
    public UserRepository userRepository() {
        return mock(MongoDBUserRepository.class);
    }

    @Bean
    public InfrastructureToDomain<UserDBO, User> mapper() {
        return mock(MapperInfrastructure.class);
    }
}