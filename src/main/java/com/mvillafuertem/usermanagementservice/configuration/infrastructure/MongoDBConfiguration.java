package com.mvillafuertem.usermanagementservice.configuration.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mvillafuertem.usermanagementservice.configuration.infrastructure.property.MongoAuthenticationManagerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoDBConfiguration {

//    @Bean
//    public MongoClient mongoClient(final MongoAuthenticationManagerProperties properties) {
//        return new MongoClient(new MongoClientURI(properties.getUri()));
//    }

//    @Bean
//    public MongoDbFactory mongoDbFactory(final MongoClient mongoClient,
//                                         final MongoAuthenticationManagerProperties properties) {
//        return new SimpleMongoDbFactory(mongoClient));
//    }

    @Bean
    public MongoDbFactory mongoDbFactory(final MongoAuthenticationManagerProperties properties) {
        return new SimpleMongoDbFactory(new MongoClientURI(properties.getUri()));
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoDbFactory mongoDbFactory){
        return new MongoTemplate(mongoDbFactory);
    }
}
