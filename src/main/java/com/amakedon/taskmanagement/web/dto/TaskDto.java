package com.amakedon.taskmanagement.web.dto;

import com.amakedon.taskmanagement.persistence.model.Task;
import com.amakedon.taskmanagement.persistence.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    private String name;

    private String description;

    private LocalDate dateCreated;

    private LocalDate dueDate;

    private TaskStatus status;

    public TaskDto(String name, String description, LocalDate dateCreated, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
    }

    public TaskDto(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.description = task.getDescription();
        this.dateCreated = task.getDateCreated();
        this.dueDate = task.getDueDate();
        this.status = task.getStatus();
    }
}
