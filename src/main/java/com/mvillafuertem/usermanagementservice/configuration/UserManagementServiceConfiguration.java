package com.mvillafuertem.usermanagementservice.configuration;

import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;

@Configuration
@ComponentScan(includeFilters = {
        @Filter(type = ASSIGNABLE_TYPE, value = MongoAutoConfiguration.class),
        @Filter(type = ASSIGNABLE_TYPE, value = MongoDataAutoConfiguration.class)})
public class UserManagementServiceConfiguration {
}
