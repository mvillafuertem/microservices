package com.mvillafuertem.usermicroservice.rest.model;

import lombok.*;

@Data
@ToString
@Builder
public class UserResponse {

    private final Long userId;
    private final String email;
    private final String lastname;
    private final String name;
}
