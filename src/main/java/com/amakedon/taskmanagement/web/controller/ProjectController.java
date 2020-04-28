package com.amakedon.taskmanagement.web.controller;

import com.amakedon.taskmanagement.events.ProjectCreatedEvent;
import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import com.amakedon.taskmanagement.web.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private ProjectService projectService;

    private ApplicationEventPublisher publisher;

    public ProjectController(ProjectService projectService, ApplicationEventPublisher publisher) {
        this.projectService = projectService;
        this.publisher = publisher;
    }

    @GetMapping(path = "/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project project = projectService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(project);
    }

    @GetMapping
    public Collection<ProjectDto> findAll() {
        Iterable<Project> allProjects = this.projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        allProjects.forEach(p -> projectDtos.add(convertToDto(p)));
        return projectDtos;
    }

    @GetMapping("/by-name")
    public Collection<ProjectDto> findProjects(@RequestParam(name = "name", defaultValue = "") String name) {
        Iterable<Project> projects = projectService.findByName(name);
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(p -> projectDtos.add(convertToDto(p)));
        return projectDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProjectDto projectDto) {
        Project project = convertToEntity(projectDto);
        Project createdProject = projectService.save(project);
        publisher.publishEvent(new ProjectCreatedEvent(createdProject.getId()));
    }

    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto updatedProject) {
        Project projectEntity = convertToEntity(updatedProject);
        return this.convertToDto(this.projectService.save(projectEntity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
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
