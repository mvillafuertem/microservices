package com.mvillafuertem.usermanagementservice.infrastructure.repository.relational.orm;

import com.mvillafuertem.usermanagementservice.infrastructure.model.UserDBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper
public interface UserRepositoryRelationalMapper {

    UserDBO insert(final UserDBO user);
    UserDBO findById(@Param("userId") final Long userId);
}

