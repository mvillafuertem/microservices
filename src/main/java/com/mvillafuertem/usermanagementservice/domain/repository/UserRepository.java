package com.mvillafuertem.usermanagementservice.domain.repository;

import com.mvillafuertem.usermanagementservice.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    User insert(User user);
    Optional<User> findById(Long userId);
}

