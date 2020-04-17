package com.amakedon.taskmanagement.web.controller;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import com.amakedon.taskmanagement.web.dto.ProjectDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model) {
        Iterable<Project> projects = projectService.findAll();
        List<ProjectDto> projectsDto = new ArrayList<>();
        projects.forEach(project -> projectsDto.add(convertToDto(project)));

        model.addAttribute("projects", projectsDto);
        return "projects";
    }

    @GetMapping("/new")
    public String newProject(Model model) {
        model.addAttribute("project", new ProjectDto());
        return "new-project";
    }

    @PostMapping
    public String addProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-project";
        }
        projectService.save(convertToEntity(projectDto));
        return "redirect:/projects";
    }


/*    @GetMapping("/{id}/add-tasks")
    public String getProjectEditPage(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id)
                .orElse(new Project());
        model.addAttribute("project", project);
        TaskListDto tasksForm = new TaskListDto();
        for (int i = 1; i <= 3; i++) {
            tasksForm.addTask(new TaskDto());
        }
        model.addAttribute("tasksForm", tasksForm);
        return "add-tasks";
    }

    @PostMapping("{id}/save-tasks")
    public String saveTasks(@ModelAttribute TaskListDto tasksForm, @PathVariable Long id, Model model) {
        Project project = projectService.findById(id)
                .orElse(new Project());
        projectService.addTasks(project, tasksForm.getTasks()
                .stream()
                .map(t -> convertTaskToEntity(t))
                .collect(Collectors.toList()));
        model.addAttribute("project", project);

        return "redirect:/projects/" + project.getId();
    }*/

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
