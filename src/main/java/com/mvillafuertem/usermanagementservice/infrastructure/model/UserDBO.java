package com.mvillafuertem.usermanagementservice.infrastructure.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
