package com.mvillafuertem.usermicroservice.rest.controller;

import com.mvillafuertem.usermicroservice.application.CreateNewUser;
import com.mvillafuertem.usermicroservice.application.GetUser;
import com.mvillafuertem.usermicroservice.domain.model.User;
import com.mvillafuertem.usermicroservice.rest.UserAPI;
import com.mvillafuertem.usermicroservice.rest.mapper.ToApplication;
import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("/users")
@Slf4j
public class UserController implements UserAPI {

    private final CreateNewUser newUser;
    private final GetUser getUser;
    private final ToApplication<UserResponse, User> mapper;


    public UserController(final CreateNewUser newUser,
                          final GetUser getUser,
                          final ToApplication<UserResponse, User> mapper) {
        this.newUser = newUser;
        this.getUser = getUser;
        this.mapper = mapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse createNewUserWithEmail(final UserResponse userResponse) {

        final User user = mapper.mapRest(userResponse);
        final User userCreated = newUser.createNewUserWithEmail(user);

        return mapper.mapApplication(userCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{userId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse getUser(@PathVariable final Long userId) {

        final User user = getUser.getUserInfoById(userId);

        return mapper.mapApplication(user);
    }
}
