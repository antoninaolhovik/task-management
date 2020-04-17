package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.model.Task;
import com.amakedon.taskmanagement.persistence.repository.ProjectRepository;
import com.amakedon.taskmanagement.service.ProjectService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project addTasks(Project project, List<Task> tasks) {
        project.getTasks()
                .addAll(tasks.stream()
                        .filter(t -> StringUtils.isNotEmpty(t.getName()))
                        .collect(Collectors.toList()));
        projectRepository.save(project);

        return project;
    }


}
