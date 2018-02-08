package com.mvillafuertem.usermicroservice.rest.mapper;

import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import com.mvillafuertem.usermicroservice.domain.model.User;

public class Mapper implements ToAPI<User, UserResponse> {

    @Override
    public UserResponse map(final User source) {
        return UserResponse.builder()
                .userId(source.getUserId())
                .email(source.getEmail())
                .lastname(source.getLastname())
                .name(source.getName())
                .build();
    }
}
