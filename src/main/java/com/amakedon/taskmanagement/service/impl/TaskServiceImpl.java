package com.amakedon.taskmanagement.service.impl;

import com.amakedon.taskmanagement.persistence.model.Task;
import com.amakedon.taskmanagement.persistence.repository.TaskRepository;
import com.amakedon.taskmanagement.service.TaskService;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> saveAll(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }
}
