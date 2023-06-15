package com.lucsilva.taskbuddy.dto.response;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProjectResponseDTO {
    Integer id;
    String title;
    String description;
    Date deadline;
    Priority priority;
    UserResponseDTO user;
    Set<ProjectTaskResponseDTO> projectTasks = new HashSet<>();

    public ProjectResponseDTO() {
    }

    public ProjectResponseDTO(Integer id, String t, String d, Date deadline, Priority p, UserResponseDTO u, Set<ProjectTaskResponseDTO> pts) {
        this.id = id;
        this.title = t;
        this.description = d;
        this.deadline = deadline;
        this.priority = p;
        this.user = u;
        projectTasks.addAll(pts);
    }

    public static ProjectResponseDTO convertToDto(Project p) {
        UserAccount user = p.getUser();
        UserResponseDTO userDto = UserResponseDTO.convertToDto(user);
        Set<ProjectTaskResponseDTO> ptsDto = new HashSet<>();

        for (ProjectTask pt : p.getProjectTasks()) {
            ProjectTaskResponseDTO ptDto = ProjectTaskResponseDTO.convertToDto(pt);
            ptsDto.add(ptDto);
        }

        return new ProjectResponseDTO(p.getId(), p.getTitle(), p.getDescription(),
                p.getDeadline(), p.getPriority(), userDto, ptsDto);
    }

    public static Set<ProjectResponseDTO> convertSetToDto(Set<Project> projects){
        Set<ProjectResponseDTO> dtos = new HashSet<>();
        for(Project p : projects){
            dtos.add(ProjectResponseDTO.convertToDto(p));
        }
        return dtos;
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

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public Set<ProjectTaskResponseDTO> getProjectTasks() {
        return projectTasks;
    }
}
