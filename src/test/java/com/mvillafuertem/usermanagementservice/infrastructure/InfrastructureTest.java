package com.mvillafuertem.usermanagementservice.infrastructure;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@ActiveProfiles("develop")
@SpringBootTest
public abstract class InfrastructureTest {

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

    public void create() throws IOException {

        readLines(resource).stream()
                .map(jsonTransaction -> (DBObject) JSON.parse(jsonTransaction))
                .forEach(transaction -> mongoTemplate.save(transaction, COLLECTION_NAME));
    }

    private List<String> readLines(Resource resource) throws IOException {

        final InputStream inputStream = Optional.of(resource.getInputStream())
                .orElseThrow(() -> new IOException("Can't read the resource file"));

        final Scanner scanner = new Scanner(inputStream);

        return readAllLines(scanner);
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