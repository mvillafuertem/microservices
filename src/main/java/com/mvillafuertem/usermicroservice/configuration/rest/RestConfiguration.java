package com.mvillafuertem.usermicroservice.configuration.rest;

import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.rest.mapper.Mapper;
import com.mvillafuertem.usermicroservice.rest.mapper.ToAPI;
import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfiguration {

    @Bean
    public ToAPI<User, UserResponse> mapper() {
        return new Mapper();
    }
}
