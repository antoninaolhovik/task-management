package com.amakedon.taskmanagement.service;

import com.amakedon.taskmanagement.persistence.model.Project;

import java.util.Optional;

public interface ProjectService {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
