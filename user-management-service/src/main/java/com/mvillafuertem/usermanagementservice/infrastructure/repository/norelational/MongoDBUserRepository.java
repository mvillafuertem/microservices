package com.mvillafuertem.usermanagementservice.infrastructure.repository.norelational;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.InfrastructureToDomain;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
public class MongoDBUserRepository implements UserRepository {

    private final MongoTemplate mongoTemplate;
    private final InfrastructureToDomain<UserDBO, User> mapper;

    public MongoDBUserRepository(final MongoTemplate mongoTemplate,
                                 final InfrastructureToDomain<UserDBO, User> mapper) {
        this.mongoTemplate = mongoTemplate;
        this.mapper = mapper;
    }

    @Override
    public User insert(final User user) {
        Optional.ofNullable(user)
                .map(mapper::mapDomain)
                .ifPresent(mongoTemplate::save);
        return user;
    }

    @Override
    public Optional<User> findById(final Long userId) {

        return Optional.ofNullable(userId)
                .map(id -> where("userId").is(id))
                .map(Query::query)
                .map(query -> mongoTemplate.find(query, UserDBO.class))
                .map(List::stream)
                .flatMap(Stream::findFirst)
                .map(mapper::mapInfrastructure);
    }

    @Override
    public List<User> findAll() {

        return mongoTemplate.findAll(UserDBO.class)
                .stream()
                .map(mapper::mapInfrastructure)
                .collect(toList());
    }
}
