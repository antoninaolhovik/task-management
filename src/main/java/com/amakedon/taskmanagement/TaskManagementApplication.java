package com.amakedon.taskmanagement;

import com.amakedon.taskmanagement.persistence.model.Project;
import com.amakedon.taskmanagement.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TaskManagementApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TaskManagementApplication.class);

	@Value("${additional.info}")
	private String additional;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@PostConstruct
	private void postConstruct() {
		LOG.info("Additional Property {}", additional);
	}

}
