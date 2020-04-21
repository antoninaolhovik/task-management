package com.amakedon.taskmanagement.web.controller;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import com.amakedon.taskmanagement.web.dto.ProjectDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public String getProjects(Model model) {
        Iterable<Project> projects = projectService.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(p -> projectDtos.add(convertToDto(p)));
        model.addAttribute("projects", projectDtos);
        return "projects";
    }

    protected ProjectDto convertToDto(Project project) {
        return new ProjectDto(project);
    }

}
