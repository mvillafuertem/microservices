package com.mvillafuertem.usermanagementservice.application.impl;

import com.mvillafuertem.usermanagementservice.application.CreateNewUser;
import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateNewUserImpl implements CreateNewUser {

    private final UserRepository repository;

    public CreateNewUserImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createNewUserWithEmail(final User user) {
        return repository.insert(user);
    }
}
