package com.lucsilva.taskbuddy.dto.response;

import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.entities.enums.Priority;

public class ProjectTaskResponseDTO {
    Integer id;
    String title;
    Priority priority;
    Boolean completed;

    public ProjectTaskResponseDTO(){}
    public ProjectTaskResponseDTO(Integer id, String title, Priority priority, Boolean completed){
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = completed;
    }

    public static ProjectTaskResponseDTO convertToDto(ProjectTask projectTask){
        return new ProjectTaskResponseDTO(projectTask.getId(), projectTask.getTitle(), projectTask.getPriority() ,
                projectTask.getCompleted());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
