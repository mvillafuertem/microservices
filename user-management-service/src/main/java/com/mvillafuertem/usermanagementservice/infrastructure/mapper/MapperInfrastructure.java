package com.mvillafuertem.usermanagementservice.infrastructure.mapper;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;

public class MapperInfrastructure implements InfrastructureToDomain<UserDBO, User> {
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
