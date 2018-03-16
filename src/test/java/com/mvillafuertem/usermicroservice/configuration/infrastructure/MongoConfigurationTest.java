package com.mvillafuertem.usermicroservice.configuration.infrastructure;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mvillafuertem.usermicroservice.configuration.environment.Develop;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.Optional;

@Develop
@Configuration
public class MongoConfigurationTest {

    @Bean
    public Mongo mongo() throws IOException {
        return createMongoClient();
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoClient mongo,
                                       final MongoProperties properties) {
        final String database = new MongoClientURI(properties.getUri()).getDatabase();
        return new MongoTemplate(mongo, database);
    }

    private MongoClient createMongoClient() throws IOException {
        final EmbeddedMongoFactoryBean embeddedMongo = new EmbeddedMongoFactoryBean();
        embeddedMongo.setBindIp("127.0.0.1");

        return Optional.ofNullable(embeddedMongo.getObject())
                .orElseThrow(() -> new IOException("Error creating test embedded mongo instance"));
    }
}
