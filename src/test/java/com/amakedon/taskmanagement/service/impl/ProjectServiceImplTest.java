package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.TestConfig;
import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(TestConfig.class)
class ProjectServiceImplTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void whenSavingProject_thenOK() {
        Project savedProject = projectService.save(new Project("name", LocalDate.now()));
        assertNotNull(savedProject);
    }


}