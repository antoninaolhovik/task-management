package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import com.amakedon.taskmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectRepository projectRepository;

    public ProjectServiceImpl() {
    }

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
