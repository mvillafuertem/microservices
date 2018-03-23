package com.mvillafuertem.usermanagementservice.configuration.rest;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.rest.mapper.MapperRest;
import com.mvillafuertem.usermanagementservice.rest.mapper.RestToApplication;
import com.mvillafuertem.usermanagementservice.rest.model.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {

    @Bean
    public RestToApplication<UserResponse, User> userRestToApplicationMapper() {
        return new MapperRest();
    }
}
