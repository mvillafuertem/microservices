package com.mvillafuertem.usermicroservice.infrastructure.mapper;

import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.infrastructure.model.UserDBO;

public class Mapper implements ToDomain<UserDBO, User> {
    @Override
    public User mapInfrastructure(final UserDBO source) {
        return User.builder()
                .userId(source.getUserId())
                .email(source.getEmail())
                .lastname(source.getLastname())
                .name(source.getName())
                .build();
    }

    @Override
    public UserDBO mapDomain(final User source) {
        return UserDBO.builder()
                .userId(source.getUserId())
                .email(source.getEmail())
                .lastname(source.getLastname())
                .name(source.getName())
                .build();
    }
}
