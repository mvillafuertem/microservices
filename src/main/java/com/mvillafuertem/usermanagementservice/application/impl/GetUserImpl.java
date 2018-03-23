package com.mvillafuertem.usermanagementservice.application.impl;

import com.mvillafuertem.usermanagementservice.application.GetUser;
import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetUserImpl implements GetUser {

    private final UserRepository repository;

    public GetUserImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserInfoById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
