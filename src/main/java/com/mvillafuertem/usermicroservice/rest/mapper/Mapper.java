package com.mvillafuertem.usermicroservice.rest.mapper;

import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import com.mvillafuertem.usermicroservice.domain.model.User;

public class Mapper implements ToApplication<UserResponse, User> {

    @Override
    public UserResponse mapApplication(final User source) {
        return UserResponse.builder()
                .userId(source.getUserId())
                .email(source.getEmail())
                .lastname(source.getLastname())
                .name(source.getName())
                .build();
    }

    @Override
    public User mapRest(final UserResponse source) {
        return User.builder()
                .userId(source.getUserId())
                .email(source.getEmail())
                .lastname(source.getLastname())
                .name(source.getName())
                .build();
    }
}
