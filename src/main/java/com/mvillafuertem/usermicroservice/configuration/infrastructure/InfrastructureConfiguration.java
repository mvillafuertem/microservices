package com.mvillafuertem.usermicroservice.configuration.infrastructure;

import com.mvillafuertem.usermicroservice.configuration.environment.Production;
import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.infrastructure.mapper.Mapper;
import com.mvillafuertem.usermicroservice.infrastructure.mapper.ToDomain;
import com.mvillafuertem.usermicroservice.infrastructure.model.UserDBO;
import com.mvillafuertem.usermicroservice.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Production
@Configuration
public class InfrastructureConfiguration {

    @Bean
    public UserRepository userRepository(final MongoTemplate mongoTemplate,
                                         final ToDomain<UserDBO, User> mapper) {
        return new UserRepository(mongoTemplate, mapper);
    }

    @Bean
    public ToDomain<UserDBO, User> mapper() {
        return new Mapper();
    }
}
