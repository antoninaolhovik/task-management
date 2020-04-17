package com.amakedon.taskmanagement.web.dto;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.persistence.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;

    @NotBlank
    private String name;

    private LocalDate createdDate;

    private Set<TaskDto> tasks;

    public ProjectDto(String name, LocalDate createdDate) {
        this.name = name;
        this.createdDate = createdDate;
        this.tasks = new HashSet<>();
    }

    public ProjectDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.createdDate = project.getCreatedDate();
        this.tasks = project.getTasks().stream().map(t -> new TaskDto(t))
                .collect(Collectors.toSet());
    }
}
