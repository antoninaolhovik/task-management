package com.amakedon.taskmanagement.persistence.repository.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryImplTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void givenProject_whenFindById_thenSuccess() {
        Project project = new Project(1L, RandomStringUtils.randomAlphabetic(6), LocalDate.now());
        projectRepository.save(project);

        Optional<Project> retrievedProject = projectRepository.findById(project.getId());
        assertEquals(project, retrievedProject.get());
    }

    @Test
    void whenSaveNewProject_thenSuccess() {
        Project project = new Project(1L, RandomStringUtils.randomAlphabetic(6), LocalDate.now());
        assertNotNull(projectRepository.save(project));
    }
}