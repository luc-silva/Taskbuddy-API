package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
//criar dto
//mexer no client se der tempo
@Service
public class ProjectTaskService {
    @Autowired
    ProjectTaskRepository projectTaskRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void updateProjectTask(ProjectTask projectTaskData, Integer id) {
        Optional<ProjectTask> possibleProjectTask = projectTaskRepository.findById(id);
        if (possibleProjectTask.isEmpty()){
            throw new NotFound("Project Task not found.");
        }

        ProjectTask projectTask = possibleProjectTask.get();
        Project project = projectRepository.findById(projectTask.getProject().getId()).get();

        project.getProjectTasks().remove(projectTask);
        projectTask.setCompleted(projectTaskData.getCompleted());

        project.getProjectTasks().add(projectTask);
        projectRepository.save(project);
        projectTaskRepository.updateProjectTaskById(id, projectTask.getCompleted());
    }
}
