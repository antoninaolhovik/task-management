package com.amakedon.taskmanagement.persistence.repository;

import com.amakedon.taskmanagement.persistence.model.Project;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
public class TestDataLoader implements ApplicationContextAware {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
        projectRepository.save(new Project(randomAlphabetic(6), LocalDate.now()));
    }
}
