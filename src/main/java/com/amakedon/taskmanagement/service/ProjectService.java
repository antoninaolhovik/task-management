package com.amakedon.taskmanagement.service;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.model.Task;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);

    Iterable<Project> findAll();

    Project addTasks(Project project, List<Task> tasks);
}
