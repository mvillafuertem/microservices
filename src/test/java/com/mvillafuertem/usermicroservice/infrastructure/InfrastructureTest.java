package com.mvillafuertem.usermicroservice.infrastructure;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("develop")
@SpringBootTest
public class InfrastructureTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("classpath:user.mongoexport")
    private Resource resource;

    private String COLLECTION_NAME = "user";

    @Before
    public void setUp() throws Exception {
        create();
    }

    @After
    public void tearDown() throws Exception {
        mongoTemplate.dropCollection(COLLECTION_NAME);
    }

    public void create() {

        readLines(resource).stream()
                .map(jsonTransaction -> (DBObject) JSON.parse(jsonTransaction))
                .forEach(transaction -> mongoTemplate.save(transaction, COLLECTION_NAME));
    }

    private List<String> readLines(Resource resource) {
        List<String> lines;
        try (Scanner scanner = new Scanner(resource.getInputStream())) {
            lines = readAllLines(scanner);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the resource file", e);
        }

        return lines;
    }

    private List<String> readAllLines(final Scanner scanner) {
        final List<String> lines = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }
}