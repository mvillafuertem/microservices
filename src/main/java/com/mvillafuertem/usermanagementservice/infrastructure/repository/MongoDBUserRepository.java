package com.mvillafuertem.usermanagementservice.infrastructure.repository;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.domain.repository.UserRepository;
import com.mvillafuertem.usermanagementservice.infrastructure.mapper.InfrastructureToDomain;
import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
public class MongoDBUserRepository implements UserRepository {

    private final MongoTemplate mongoTemplate;
    private final InfrastructureToDomain<UserDBO, User> mapper;
    private final String COLLECTION_NAME = "users";

    public MongoDBUserRepository(final MongoTemplate mongoTemplate,
                                 final InfrastructureToDomain<UserDBO, User> mapper) {
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
