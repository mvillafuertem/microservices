package com.mvillafuertem.usermicroservice.application;

import com.mvillafuertem.usermicroservice.domain.model.User;

public interface CreateNewUser {

    User createNewUserWithEmail(User user);
}
