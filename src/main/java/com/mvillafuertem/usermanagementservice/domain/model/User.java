package com.mvillafuertem.usermanagementservice.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class User {

    private final Long userId;
    private final String email;
    private final String lastname;
    private final String name;

}