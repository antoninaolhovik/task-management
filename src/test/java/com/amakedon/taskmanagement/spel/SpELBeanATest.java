package com.amakedon.taskmanagement.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpELBeanATest {

    @Autowired
    private SpELBeanA spELBeanA;

    @Test
    public void whenSpELBeanA_thenAllResolvedCorrectly() {
        assertNotNull(spELBeanA);
    }

}