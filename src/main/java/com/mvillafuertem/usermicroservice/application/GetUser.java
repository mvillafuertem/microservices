package com.mvillafuertem.usermicroservice.application;

import com.mvillafuertem.usermicroservice.domain.model.User;

public interface GetUser {

    User getUserInfoById(Long id);
}
