package com.amakedon.taskmanagement.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreatedEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectCreatedEventListener.class);

    @EventListener
    public void handleProjectCreatedEvent(ProjectCreatedEvent projectCreatedEvent) {
        LOG.info("Event. Project created with Id {}", projectCreatedEvent.getProjectId());
    }
}
