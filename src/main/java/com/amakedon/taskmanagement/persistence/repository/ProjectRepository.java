package com.amakedon.taskmanagement.persistence.repository;

import com.amakedon.taskmanagement.persistence.model.Project;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ProjectRepository {

    Optional<Project> findById(Long id);

    Project save(Project project);
}
