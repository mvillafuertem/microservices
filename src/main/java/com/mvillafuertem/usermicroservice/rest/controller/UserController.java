package com.mvillafuertem.usermicroservice.rest.controller;

import com.mvillafuertem.usermicroservice.rest.UserAPI;
import com.mvillafuertem.usermicroservice.rest.mapper.ToAPI;
import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import com.mvillafuertem.usermicroservice.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
@Slf4j
public class UserController implements UserAPI {

    private final ToAPI<User, UserResponse> mapper;

    public UserController(final ToAPI<User, UserResponse> mapper) {
        this.mapper = mapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public UserResponse createNewUserWithEmail(final User user) {
        return mapper.map(user);
    }
}
