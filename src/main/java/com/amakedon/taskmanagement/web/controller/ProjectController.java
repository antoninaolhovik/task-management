package com.amakedon.taskmanagement.web.controller;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import com.amakedon.taskmanagement.web.dto.ProjectDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(project);
    }

    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        Project project = convertToEntity(projectDto);
        projectService.save(project);
    }

    protected ProjectDto convertToDto(Project project) {
        return new ProjectDto(project);
    }

    protected Project convertToEntity(ProjectDto dto) {
        Project project = new Project(dto.getName(), dto.getCreatedDate());
        if (dto.getId() != null) {
            project.setId(dto.getId());
        }
        return project;
    }

}
