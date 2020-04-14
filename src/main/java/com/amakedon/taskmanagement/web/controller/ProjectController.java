package com.amakedon.taskmanagement.web.controller;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/{id}")
    public Project findOne(@PathVariable Long id) {
        return projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void create(@RequestBody Project project) {
        projectService.save(project);
    }
}
