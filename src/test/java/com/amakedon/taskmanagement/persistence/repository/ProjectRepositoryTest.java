package com.amakedon.taskmanagement.persistence.repository;

import com.amakedon.taskmanagement.persistence.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void givenProject_whenFindById_thenSuccess() {
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(project);

        Optional<Project> retrievedProject = projectRepository.findById(project.getId());
        assertTrue(retrievedProject.isPresent());
        assertEquals(project, retrievedProject.get());
    }

    @Test
    void givenProject_whenFindByName_thenSuccess() {
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(project);

        Optional<Project> retrievedProject = projectRepository.findByName(project.getName());
        assertTrue(retrievedProject.isPresent());
        assertEquals(project, retrievedProject.get());
    }

    @Test
    void givenProject_whenFindByCreatedDateBetween_thenSuccess() {
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(project);

        Optional<Project> retrievedProject = projectRepository.findByName(project.getName());
        assertTrue(retrievedProject.isPresent());
        assertEquals(project, retrievedProject.get());
    }

    @Test
    void whenSaveNewProject_thenSuccess() {
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusMonths(1));
        projectRepository.save(oldProject);

        Project newProject1 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject1);

        Project newProject2 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);

        List<Project> projects = projectRepository.findByCreatedDateBetween(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertThat(projects, containsInAnyOrder(newProject1, newProject2));
    }

    @Test
    public void givenDataCreated_whenFindAllPaginated_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2));
        assertEquals(2, retrievedProjects.getContent().size());

    }

    @Test
    public void givenDataCreated_whenFindAllSorted_thenSuccess() {
        List<Project> retrievedProjects = (List<Project>) projectRepository.findAll(Sort.by(Sort.Order.asc("name")));

        List<Project> sortedProjects = retrievedProjects.stream().collect(Collectors.toList());
        sortedProjects.sort(Comparator.comparing(Project::getName));

        assertEquals(sortedProjects, retrievedProjects);
    }

    @Test
    public void givenDataCreated_whenFindAllPaginatedAndSorted_thenSuccess() {
        Page<Project> retrievedProjects = projectRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.asc("name"))));
        assertEquals(2, retrievedProjects.getContent().size());
    }
}