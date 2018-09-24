package com.mvillafuertem.usermanagementservice.configuration.infrastructure;

import com.mongodb.MongoClient;
import com.mvillafuertem.usermanagementservice.configuration.environment.Develop;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.Optional;

@Develop
@Configuration
public class MongoTestConfiguration {

    @Bean
    public MongoClient mongo() throws IOException {
        return createMongoClient();
    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoClient mongo) {
        return new MongoTemplate(mongo, "TestDB");
    }

    private MongoClient createMongoClient() throws IOException {
        final EmbeddedMongoFactoryBean embeddedMongo = new EmbeddedMongoFactoryBean();
        embeddedMongo.setBindIp("127.0.0.1");

        return Optional.ofNullable(embeddedMongo.getObject())
                .orElseThrow(() -> new IOException("Error creating test embedded mongo instance"));
    }
}
