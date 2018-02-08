package com.mvillafuertem.usermicroservice.application.impl;

import com.mvillafuertem.usermicroservice.application.GetUser;
import com.mvillafuertem.usermicroservice.domain.Repository;
import com.mvillafuertem.usermicroservice.domain.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetUserImpl implements GetUser {

    private final Repository repository;

    public GetUserImpl(final Repository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserInfoById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
