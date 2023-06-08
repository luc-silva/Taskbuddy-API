package com.lucsilva.taskbuddy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "USER_ID")
    UserAccount user;

    @OneToMany(mappedBy = "project")
    Set<ProjectTask> projectTasks = new HashSet<>();

    String title;
    String description;
    Date deadline;
    Priority priority;

    public Project() {
    }

    public Project(Integer id, UserAccount user, String title, String description, Date deadline, Priority priority) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
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

    public UserAccount getUser() {
        return user;
    }

    public Set<ProjectTask> getProjectTasks() {
        return projectTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }
}
