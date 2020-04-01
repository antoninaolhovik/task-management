package com.amakedon.taskmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(TestConfig.class)
@TestPropertySource(locations = "classpath:test.properties")
public class TestPropertySourceTest {


    @Value("${testProperty}")
    private String testProperty;

    @Value("${additional.info}")
    private String additional;

    @Test
    public void whenTestPropertySource_thenValuesRetreived() {
        assertEquals("Test Property Value", testProperty);
    }

    @Test
    public void whenPropertyDefinedInMain_thenValuesRetrieved() {
        assertEquals("Additional Info", additional);
    }
}
