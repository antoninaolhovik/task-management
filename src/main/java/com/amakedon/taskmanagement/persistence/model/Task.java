package com.amakedon.taskmanagement.persistence.model;

import com.amakedon.taskmanagement.web.dto.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;

    private LocalDate dueDate;

    private TaskStatus status;

    public Task(String name, String description, LocalDate dateCreated, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
    }

    public Task(TaskDto taskDto) {
        this.id = taskDto.getId();
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.dateCreated = taskDto.getDateCreated();
        this.dueDate = taskDto.getDueDate();
        this.status = taskDto.getStatus();
    }
}
