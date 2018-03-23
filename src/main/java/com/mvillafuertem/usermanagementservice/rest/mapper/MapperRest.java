package com.mvillafuertem.usermanagementservice.rest.mapper;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.rest.model.UserResponse;

public class MapperRest implements RestToApplication<UserResponse, User> {

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
