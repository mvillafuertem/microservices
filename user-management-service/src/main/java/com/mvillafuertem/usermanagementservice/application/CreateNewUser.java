package com.mvillafuertem.usermanagementservice.application;

import com.mvillafuertem.usermanagementservice.domain.model.User;

public interface CreateNewUser {

    User createNewUserWithEmail(User user);
}
