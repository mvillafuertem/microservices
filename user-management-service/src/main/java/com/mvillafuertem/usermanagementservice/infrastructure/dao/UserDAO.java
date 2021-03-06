package com.mvillafuertem.usermanagementservice.infrastructure.dao;

import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

    Long insert(UserDBO user);
    UserDBO findById(Long id);
}
