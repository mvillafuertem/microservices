package com.mvillafuertem.usermanagementservice.rest.controller;

import com.mvillafuertem.usermanagementservice.application.CreateNewUser;
import com.mvillafuertem.usermanagementservice.application.GetUser;
import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.rest.UserAPI;
import com.mvillafuertem.usermanagementservice.rest.mapper.RestToApplication;
import com.mvillafuertem.usermanagementservice.rest.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController implements UserAPI {

    private final CreateNewUser createNewUser;
    private final GetUser getUser;
    private final RestToApplication<UserResponse, User> apiToDomainMapper;


    public UserController(final CreateNewUser createNewUser,
                          final GetUser getUser,
                          final RestToApplication<UserResponse, User> apiToDomainMapper) {
        this.createNewUser = createNewUser;
        this.getUser = getUser;
        this.apiToDomainMapper = apiToDomainMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse createNewUserWithEmail(final UserResponse userResponse) {

        final User user = apiToDomainMapper.mapRest(userResponse);
        final User userCreated = createNewUser.createNewUserWithEmail(user);

        return apiToDomainMapper.mapApplication(userCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{userId}",
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse getUser(@PathVariable final Long userId) {

        log.debug("Application getUser {}", userId);

        final User user = getUser.getUserInfoById(userId);

        return apiToDomainMapper.mapApplication(user);
    }
}
