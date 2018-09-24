package com.mvillafuertem.usermanagementservice.infrastructure.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Builder
@EqualsAndHashCode
@ToString
public class UserDBO {

    @Id
    private final String id;
    private final Long userId;
    private final String email;
    private final String lastname;
    private final String name;
}
