package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.ProjectTaskRepository;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectTaskRepository projectTaskRepository;

    public void createProject(Project project) {
        if (project.getProjectTasks().isEmpty()) {
            throw new IllegalArgumentException("Project must have at least one task.");
        }
        if(project.getUser() == null){
            throw new IllegalArgumentException("Project must have an owner.");
        }

        Optional<UserAccount> userAccount = userRepository.findById(project.getUser().getId());
        if(userAccount.isEmpty()){
            throw new NotFound("User not found.");
        }
        UserAccount projectOwner = userAccount.get();
        projectOwner.getProjects().add(project);

        projectRepository.save(project);
        projectTaskRepository.saveAll(project.getProjectTasks());
        userRepository.save(projectOwner);


    }

    public void updateProject(Project updatedProject) {
        projectRepository.updateProject(updatedProject.getId(), updatedProject.getTitle(), updatedProject.getDescription(),
                updatedProject.getPriority(), updatedProject.getDeadline());

    }

    public void deleteProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            Project projectFound = project.get();
            Optional<UserAccount> projectOwner = userRepository.findById(projectFound.getUser().getId());
            if(projectOwner.isEmpty()){
                throw new NotFound();
            }
            UserAccount user = projectOwner.get();
            user.getProjects().remove(project.get());

            Set<ProjectTask> projectTask = projectTaskRepository.getProjectTaskByProjectId(projectFound.getId());
            projectTaskRepository.deleteAll(projectTask);
            projectRepository.delete(project.get());
        }

    }

}
