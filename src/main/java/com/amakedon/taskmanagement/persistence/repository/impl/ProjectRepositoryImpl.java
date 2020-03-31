package com.amakedon.taskmanagement.persistence.repository.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepositoryImpl.class);

    private List<Project> projects = new ArrayList<>();

    public ProjectRepositoryImpl() {
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Find by id={}", id);
        return projects.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Save={}", project);
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject ==  null) {
            projects.add(project);
        } else {
            projects.remove(existingProject);
            projects.add(new Project(project));
        }
        return project;
    }

}
