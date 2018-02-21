package com.mvillafuertem.usermicroservice.infrastructure;

import com.mvillafuertem.usermicroservice.domain.Repository;
import com.mvillafuertem.usermicroservice.domain.model.User;

import java.util.Optional;

public class UserRepository implements Repository {
    @Override
    public User insert(final User user) {
        return null;
    }

    @Override
    public Optional<User> findById(final Long userId) {
        return Optional.empty();
    }
}
