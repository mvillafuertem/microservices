package com.mvillafuertem.usermanagementservice.infrastructure.repository.relational;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.InfrastructureToDomain;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm.UserRepositoryRelationalMapper;

import java.util.List;
import java.util.Optional;

public class RelationalDBUserRepository implements UserRepository {

    private final InfrastructureToDomain<UserDBO, User> mapper;
    private final UserRepositoryRelationalMapper repositoryRelationalMapper;

    public RelationalDBUserRepository(final InfrastructureToDomain<UserDBO, User> mapper, final UserRepositoryRelationalMapper repositoryRelationalMapper) {
        this.mapper = mapper;
        this.repositoryRelationalMapper = repositoryRelationalMapper;
    }

    @Override
    public User insert(final User user) {

        return Optional.ofNullable(user)
                .map(mapper::mapDomain)
                .map(repositoryRelationalMapper::insert)
                .map(mapper::mapInfrastructure)
                .orElse(null);
    }

    @Override
    public Optional<User> findById(final Long userId) {

        return Optional.ofNullable(userId)
                .map(repositoryRelationalMapper::findById)
                .map(mapper::mapInfrastructure);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
