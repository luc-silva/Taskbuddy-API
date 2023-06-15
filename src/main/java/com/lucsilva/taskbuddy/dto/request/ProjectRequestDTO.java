package com.lucsilva.taskbuddy.dto.request;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProjectRequestDTO {
    UserAccountRequestDTO user;
    Set<ProjectTask> projectTasks = new HashSet<>();
    String title;
    String description;
    Date deadline;
    Priority priority;

    public ProjectRequestDTO(){}
    public Project convertToObject(){
        UserAccount user = this.getUser().convertToObject();
        return new Project(user, getProjectTasks(),getTitle(), getDescription(), getDeadline(), getPriority());
    }

    public UserAccountRequestDTO getUser() {
        return user;
    }

    public void setUser(UserAccountRequestDTO user) {
        this.user = user;
    }

    public Set<ProjectTask> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(Set<ProjectTask> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
