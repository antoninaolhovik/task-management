package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(ProjectServiceImplTest.Config.class)
class ProjectServiceImplTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project(1L, "name", LocalDate.now()));
        assertNotNull(savedProject);
    }


    @Configuration
    @ComponentScan("com.amakedon.taskmanagement")
    static class Config {}

}