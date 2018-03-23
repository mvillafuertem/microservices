package com.mvillafuertem.usermanagementservice.configuration.application;

import com.mvillafuertem.usermanagementservice.application.CreateNewUser;
import com.mvillafuertem.usermanagementservice.application.GetUser;
import com.mvillafuertem.usermanagementservice.application.impl.CreateNewUserImpl;
import com.mvillafuertem.usermanagementservice.application.impl.GetUserImpl;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
