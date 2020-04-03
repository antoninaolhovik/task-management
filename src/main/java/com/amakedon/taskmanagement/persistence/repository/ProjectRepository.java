package com.amakedon.taskmanagement.persistence.repository;

import com.amakedon.taskmanagement.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findByName(String name);

    List<Project> findByCreatedDateBetween(LocalDate start, LocalDate end);

}
