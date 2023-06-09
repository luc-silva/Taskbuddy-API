package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.ProjectTaskRepository;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        projectRepository.save(project);
        projectTaskRepository.saveAll(project.getProjectTasks());

    }

    public void updateProject(Project updatedProject) {
        projectRepository.updateProject(updatedProject.getId(), updatedProject.getTitle(), updatedProject.getDescription(),
                updatedProject.getPriority(), updatedProject.getDeadline());

    }

    public void deleteProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            Project projectFound = project.get();
            Optional<UserAccount> user = userRepository.findById(projectFound.getUser().getId());
            user.get().getProjects().remove(project.get());
            projectRepository.delete(project.get());
        }

    }

}
