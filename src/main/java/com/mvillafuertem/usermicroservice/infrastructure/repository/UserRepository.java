package com.mvillafuertem.usermicroservice.infrastructure.repository;

import com.mvillafuertem.usermicroservice.domain.repository.Repository;
import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.infrastructure.mapper.ToDomain;
import com.mvillafuertem.usermicroservice.infrastructure.model.UserDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
public class UserRepository implements Repository {

    private final MongoTemplate mongoTemplate;
    private final ToDomain<UserDBO, User> mapper;
    private final String COLLECTION_NAME = "user";

    public UserRepository(final MongoTemplate mongoTemplate,
                          final ToDomain<UserDBO, User> mapper) {
        this.mongoTemplate = mongoTemplate;
        this.mapper = mapper;
    }

    @Override
    public User insert(final User user) {
        final UserDBO userDBO = mapper.mapDomain(user);
        mongoTemplate.insert(userDBO, COLLECTION_NAME);
        return user;
    }

    @Override
    public Optional<User> findById(final Long userId) {

        final List<UserDBO> userDBO = mongoTemplate.find(
                Query.query(whereUserIdIs(userId)),
                UserDBO.class,
                COLLECTION_NAME
        );

        return userDBO.stream().map(mapper::mapInfrastructure).findFirst();
    }

    private static Criteria whereUserIdIs(final Long userId) {
        return where("userId").is(userId);
    }
}
