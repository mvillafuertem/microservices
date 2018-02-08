package com.mvillafuertem.usermicroservice.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Environment {

    public static final String TEST = "TEST";
    public static final String INTEGRATION_TEST = "INTEGRATION";
    public static final String PRODUCTION = "PRODUCTION";
}
