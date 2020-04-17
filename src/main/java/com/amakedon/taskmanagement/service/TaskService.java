package com.amakedon.taskmanagement.service;

import com.amakedon.taskmanagement.persistence.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<Task> findById(Long id);

    Task save(Task task);

    Iterable<Task> saveAll(List<Task> tasks);
}
