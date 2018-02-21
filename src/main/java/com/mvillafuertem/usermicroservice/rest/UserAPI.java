package com.mvillafuertem.usermicroservice.rest;

import com.mvillafuertem.usermicroservice.rest.model.UserResponse;
import com.mvillafuertem.usermicroservice.domain.model.User;

public interface UserAPI {

    UserResponse createNewUserWithEmail(final UserResponse user);

    UserResponse getUser(final Long userId);

}
