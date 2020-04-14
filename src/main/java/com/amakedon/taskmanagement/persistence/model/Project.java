package com.amakedon.taskmanagement.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate createdDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Task> tasks;

    public Project(Project project) {
        this(project.getName(), project.getCreatedDate());
        this.tasks = project.getTasks()
                .stream()
                .collect(Collectors.toSet());
    }

    public Project(String name, LocalDate createdDate) {
        this.name = name;
        this.createdDate = createdDate;
        this.tasks = new HashSet<>();
    }
}
