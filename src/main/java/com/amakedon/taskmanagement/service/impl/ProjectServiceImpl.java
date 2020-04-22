package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import com.amakedon.taskmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

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
        if (project.getId() == null) {
            project.setCreatedDate(LocalDate.now());
        }
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> findByName(String name) {
        return projectRepository.findByNameContaining(name);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }


}
