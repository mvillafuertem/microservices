package com.mvillafuertem.usermanagementservice.domain.repository;

import com.mvillafuertem.usermanagementservice.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User insert(final User user);
    Optional<User> findById(final Long userId);
    List<User> findAll();
}

