package com.mvillafuertem.usermicroservice.infrastructure.repository;

import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.infrastructure.InfrastructureTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class UserRepositoryTest extends InfrastructureTest {

    @Autowired
    private UserRepository repository;

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