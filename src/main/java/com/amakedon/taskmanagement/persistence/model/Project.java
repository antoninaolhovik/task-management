package com.amakedon.taskmanagement.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
//@AllArgsConstructor
public class Project {

    private Long id;

    private String name;

    private LocalDate createdDate;

    public Project(Project project) {
        this(project.getId(), project.getName(), project.getCreatedDate());
    }

    public Project(Long id, String name, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }
}
