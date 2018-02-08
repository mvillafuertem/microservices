package com.mvillafuertem.usermicroservice.infrastructure.dao;

import com.mvillafuertem.usermicroservice.infrastructure.model.UserDBO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

    Long insert(UserDBO user);
    UserDBO findById(Long id);
}
