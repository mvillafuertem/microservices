package com.mvillafuertem.usermicroservice.domain.repository;

import com.mvillafuertem.usermicroservice.domain.model.User;

import java.util.Optional;

public interface Repository {

    User insert(User user);
    Optional<User> findById(Long userId);
}

