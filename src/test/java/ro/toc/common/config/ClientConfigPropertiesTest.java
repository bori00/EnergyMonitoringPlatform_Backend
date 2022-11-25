package ro.toc.common.config;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.tuc.common.config.ClientConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ClientConfigProperties.class})
class ClientConfigPropertiesTest {

    @Autowired
    private ClientConfigProperties configProperties;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void getClientUrl() {
        assertEquals("http://localhost:3000", configProperties.getClientUrl());
    }
}