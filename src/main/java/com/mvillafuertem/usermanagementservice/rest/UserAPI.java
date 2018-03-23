package com.mvillafuertem.usermanagementservice.rest;

import com.mvillafuertem.usermanagementservice.rest.model.UserResponse;

public interface UserAPI {

    UserResponse createNewUserWithEmail(final UserResponse user);

    UserResponse getUser(final Long userId);

}
