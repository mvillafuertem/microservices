package com.mvillafuertem.usermicroservice.rest.controller;

import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.rest.UserAPI;
import com.mvillafuertem.usermicroservice.rest.mapper.ToAPI;
import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("/users")
@Slf4j
public class UserController implements UserAPI {

    private final ToAPI<User, UserResponse> mapper;

    public UserController(final ToAPI<User, UserResponse> mapper) {
        this.mapper = mapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse createNewUserWithEmail(final User user) {
        return mapper.map(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{userId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse getUser(@PathVariable final Long userId) {
        final User user = User.builder().userId(userId).build();
        return mapper.map(user);
    }
}
