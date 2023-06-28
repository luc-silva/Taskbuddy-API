package com.lucsilva.taskbuddy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProjectTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    Priority priority;
    @Column(nullable = false)
    Boolean completed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    Project project;

    public ProjectTask() {
    }

    public ProjectTask(Integer id, String title, Priority priority, Project project, Boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.project = project;
        this.completed = completed;
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
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && priority == that.priority && Objects.equals(completed, that.completed) && Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, priority, completed, project);
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                ", project=" + project +
                '}';
    }
}
