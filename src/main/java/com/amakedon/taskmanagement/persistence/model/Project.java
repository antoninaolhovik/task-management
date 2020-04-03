package com.amakedon.taskmanagement.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
//@AllArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate createdDate;

    public Project() {
    }

    public Project(Project project) {
        this(project.getName(), project.getCreatedDate());
    }

    public Project(String name, LocalDate createdDate) {
        this.name = name;
        this.createdDate = createdDate;
    }
}
