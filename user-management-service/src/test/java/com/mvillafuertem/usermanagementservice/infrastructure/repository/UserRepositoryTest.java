package com.mvillafuertem.usermanagementservice.infrastructure.repository;

import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.infrastructure.InfrastructureTest;
import com.mvillafuertem.usermanagementservice.infrastructure.repository.norelational.MongoDBUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class UserRepositoryTest extends InfrastructureTest {

    @Autowired
    private MongoDBUserRepository repository;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void insert() {

    }

    @Test
    public void findById() {

        // Given
        final Long userId = 1L;

        // When
        final Optional<User> user = repository.findById(userId);

        // Then
        assertThat(user).isNotEmpty();
    }
}