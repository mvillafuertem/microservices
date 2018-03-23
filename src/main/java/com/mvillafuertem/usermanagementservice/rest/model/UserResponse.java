package com.mvillafuertem.usermanagementservice.rest.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserResponse {

    private final Long userId;
    private final String email;
    private final String lastname;
    private final String name;
}
