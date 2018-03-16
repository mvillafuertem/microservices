package com.mvillafuertem.usermicroservice.configuration.application;

import com.mvillafuertem.usermicroservice.application.CreateNewUser;
import com.mvillafuertem.usermicroservice.application.GetUser;
import com.mvillafuertem.usermicroservice.application.impl.CreateNewUserImpl;
import com.mvillafuertem.usermicroservice.application.impl.GetUserImpl;
import com.mvillafuertem.usermicroservice.configuration.environment.Develop;
import com.mvillafuertem.usermicroservice.configuration.environment.Production;
import com.mvillafuertem.usermicroservice.infrastructure.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Production
@Configuration
public class ApplicationConfiguration {

    @Bean
    public CreateNewUser newUser(final UserRepository repository) {
        return new CreateNewUserImpl(repository);
    }

    @Bean
    public GetUser getUser(final UserRepository repository) {
        return new GetUserImpl(repository);
    }
}
