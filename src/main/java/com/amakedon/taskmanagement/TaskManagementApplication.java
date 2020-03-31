package com.amakedon.taskmanagement;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class TaskManagementApplication {

	private ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@PostConstruct
	private void postConstruct() {
		projectService.save(new Project(1L, "test", LocalDate.now()));
	}

    @Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
