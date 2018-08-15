package com.mvillafuertem.usermanagementservice.configuration.api;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.api.mapper.MapperRest;
import com.mvillafuertem.usermanagementservice.api.mapper.RestToApplication;
import com.mvillafuertem.usermanagementservice.api.model.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {

    @Bean
    public RestToApplication<UserResponse, User> userRestToApplicationMapper() {
        return new MapperRest();
    }
}
