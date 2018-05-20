package com.mvillafuertem.usermanagementservice.configuration.infrastructure;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.InfrastructureToDomain;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.MapperInfrastructure;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.norelational.MongoDBUserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.RelationalDBUserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm.UserRepositoryRelationalMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class InfrastructureConfiguration {

    public static final String MONGO_USER_REPOSITORY = "MongoDBUserRepository";

    public static final String RELATIONAL_USER_REPOSITORY = "RelationalDBUserRepository";

    @Bean(name = MONGO_USER_REPOSITORY)
    public UserRepository userRepository(final MongoTemplate mongoTemplate,
                                         final InfrastructureToDomain<UserDBO, User> userInfrastructureToDomainMapper) {
        return new MongoDBUserRepository(mongoTemplate, userInfrastructureToDomainMapper);
    }

    @Bean(name = RELATIONAL_USER_REPOSITORY)
    public UserRepository userRelationalRepository(final InfrastructureToDomain<UserDBO, User> mapper,
                                                   final UserRepositoryRelationalMapper relationalRepositoryMapper) {
        return new RelationalDBUserRepository(mapper, relationalRepositoryMapper);
    }

    @Bean
    public InfrastructureToDomain<UserDBO, User> userInfrastructureToDomainMapper() {
        return new MapperInfrastructure();
    }
}
