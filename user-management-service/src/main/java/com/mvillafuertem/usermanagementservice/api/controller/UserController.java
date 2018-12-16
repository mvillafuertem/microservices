package com.mvillafuertem.usermanagementservice.api.controller;

import com.mvillafuertem.usermanagementservice.application.CreateNewUser;
import com.mvillafuertem.usermanagementservice.application.GetUser;
import com.mvillafuertem.usermanagementservice.domain.model.User;
import com.mvillafuertem.usermanagementservice.api.UserAPI;
import com.mvillafuertem.usermanagementservice.api.mapper.RestToApplication;
import com.mvillafuertem.usermanagementservice.api.model.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
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
    @PutMapping(
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse createNewUserWithEmail(@RequestBody final UserResponse userResponse) {

        log.debug("UserController request createNewUserWithEmail with data {}", userResponse);

        final User user = apiToDomainMapper.mapRest(userResponse);
        final User userCreated = createNewUser.createNewUserWithEmail(user);

        log.debug("UserController response createNewUserWithEmail with data {}", userResponse);

        return apiToDomainMapper.mapApplication(userCreated);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{userId}",
            produces = APPLICATION_JSON_VALUE)
    @Override
    public UserResponse getUser(@PathVariable final Long userId) {

        log.debug("UserController request getUser with userId {}", userId);

        final User user = getUser.getUserInfoById(userId);
        final UserResponse userResponse = apiToDomainMapper.mapApplication(user);

        log.debug("UserController response getUser with user {}", userResponse);
        return userResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @Override
    public List<UserResponse> getUsers() {

        log.debug("UserController request getUsers");

        final List<UserResponse> responseList = getUser.getUsersInfoFindAll().stream()
                .map(apiToDomainMapper::mapApplication)
                .collect(toList());

        log.debug("UserController response getUsers", responseList);
        return responseList;
    }
}
