package com.mvillafuertem.usermanagementservice.application;

import com.mvillafuertem.usermanagementservice.domain.model.User;

public interface GetUser {

    User getUserInfoById(Long id);
}
