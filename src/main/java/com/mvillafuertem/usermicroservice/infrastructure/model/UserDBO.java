package com.mvillafuertem.usermicroservice.infrastructure.model;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class UserDBO {

    private final Long userId;
    private final String email;
    private final String lastname;
    private final String name;
}
