package com.mvillafuertem.usermicroservice.application.impl;

import com.mvillafuertem.usermicroservice.application.CreateNewUser;
import com.mvillafuertem.usermicroservice.domain.Repository;
import com.mvillafuertem.usermicroservice.domain.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateNewUserImpl implements CreateNewUser {

    private final Repository repository;

    public CreateNewUserImpl(final Repository repository) {
        this.repository = repository;
    }

    @Override
    public Long createNewUserWithEmail(final User user) {
        return repository.insert(user);
    }
}
