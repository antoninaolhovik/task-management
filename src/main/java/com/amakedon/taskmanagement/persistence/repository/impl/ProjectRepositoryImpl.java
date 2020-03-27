package com.amakedon.taskmanagement.persistence.repository.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private List<Project> projects = new ArrayList<>();

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
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
