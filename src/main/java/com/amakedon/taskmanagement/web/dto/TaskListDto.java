package com.amakedon.taskmanagement.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskListDto {

    private List<TaskDto> tasks = new ArrayList<>();

    public void addTask(TaskDto task) {
        this.tasks.add(task);
    }

}
