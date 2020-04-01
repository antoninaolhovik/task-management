package com.amakedon.taskmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TaskManagementApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TaskManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

	@PostConstruct
	private void postConstruct() {
	}

}
