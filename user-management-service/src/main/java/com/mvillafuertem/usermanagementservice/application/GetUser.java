package com.mvillafuertem.usermanagementservice.application;

import com.mvillafuertem.usermanagementservice.domain.model.User;

import java.util.List;

public interface GetUser {

    User getUserInfoById(final Long id);
    List<User> getUsersInfoFindAll();
}
