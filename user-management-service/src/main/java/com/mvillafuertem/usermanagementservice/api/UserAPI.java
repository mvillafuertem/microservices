package com.mvillafuertem.usermanagementservice.api;

import com.mvillafuertem.usermanagementservice.api.model.UserResponse;

import java.util.List;

public interface UserAPI {

    UserResponse createNewUserWithEmail(final UserResponse user);

    UserResponse getUser(final Long userId);

    List<UserResponse> getUsers();

}
