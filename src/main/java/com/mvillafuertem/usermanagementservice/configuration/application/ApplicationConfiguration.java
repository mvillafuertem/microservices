package com.mvillafuertem.usermanagementservice.configuration.application;

import com.mvillafuertem.usermanagementservice.application.CreateNewUser;
import com.mvillafuertem.usermanagementservice.application.GetUser;
import com.mvillafuertem.usermanagementservice.application.impl.CreateNewUserImpl;
import com.mvillafuertem.usermanagementservice.application.impl.GetUserImpl;
import com.mvillafuertem.usermanagementservice.configuration.infrastructure.InfrastructureConfiguration;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateNewUser newUser(@Qualifier(InfrastructureConfiguration.MONGO_USER_REPOSITORY) final UserRepository repository) {
        return new CreateNewUserImpl(repository);
    }

    @Bean
    public GetUser getUser(@Qualifier(InfrastructureConfiguration.MONGO_USER_REPOSITORY) final UserRepository repository) {
        return new GetUserImpl(repository);
    }
}
