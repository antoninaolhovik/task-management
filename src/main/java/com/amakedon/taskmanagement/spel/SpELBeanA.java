package com.amakedon.taskmanagement.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{spELBeanB.prop1}")
    private String otherBeanProp;
}
