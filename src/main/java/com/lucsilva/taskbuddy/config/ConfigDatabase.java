package com.lucsilva.taskbuddy.config;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.ProjectTaskRepository;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import com.lucsilva.taskbuddy.resources.UserResource;
import com.lucsilva.taskbuddy.services.ProjectService;
import com.lucsilva.taskbuddy.services.ProjectTaskService;
import com.lucsilva.taskbuddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Date;

@Configuration
@Profile("test")
public class ConfigDatabase implements CommandLineRunner {
    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectTaskService projectTaskService;



    @Override
    public void run(String... args) throws Exception {
        //userRepository.save(new UserAccount(null, "maria", "teste", "123"));

        UserAccount user1 = new UserAccount(null, "maria", "teste", "123");
        Project project1 = new Project(null, user1, "teste", "teste", new Date(), Priority.HIGH);
        ProjectTask projectTask = new ProjectTask(null, "teste", Priority.HIGH, project1);
        project1.getProjectTasks().add(projectTask);
        //testar os retornos dos projetos

        userService.createAccount(user1);
        projectService.createProject(project1);
    }
}
