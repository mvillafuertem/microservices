package com.mvillafuertem.usermanagementservice.configuration.infrastructure.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "infrastructure.mongo")
@Getter
public class MongoAuthenticationManagerProperties {

    private String database;

    @NotNull
    @NotEmpty
    private String uri;

}
