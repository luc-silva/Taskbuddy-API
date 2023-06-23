package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectTaskService {
    @Autowired
    ProjectTaskRepository projectTaskRepository;
    @Autowired
    ProjectRepository projectRepository;

    public ProjectTask getProjectTask(Integer id) {
        Optional<ProjectTask> optionalProjectTask = projectTaskRepository.findById(id);
        if (optionalProjectTask.isEmpty()) {
            throw new NotFound("Project Task not found.");
        }
        ProjectTask projectTask = optionalProjectTask.get();
        return projectTask;
    }

    public void updateProjectTask(ProjectTask projectTaskData, Integer id) {
        Optional<ProjectTask> optionalProjectTask = projectTaskRepository.findById(id);
        if (optionalProjectTask.isEmpty()) {
            throw new NotFound("Project Task not found.");
        }
        ProjectTask projectTask = optionalProjectTask.get();

        projectTask.setCompleted(projectTaskData.getCompleted());
        System.out.println(projectTaskData.getCompleted());

        projectTaskRepository.save(projectTask);
        //projectTaskRepository.updateProjectTaskById(id, projectTask.getCompleted());
    }
}
