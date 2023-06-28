package com.lucsilva.taskbuddy.entities;

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
    @JoinColumn(name = "USER_ID", nullable = false)
    UserAccount user;

    @OneToMany(mappedBy = "project")
    Set<ProjectTask> projectTasks = new HashSet<>();

    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    Date deadline;
    @Column(nullable = false)
    Priority priority;
    @Column(nullable = false)
    Boolean concluded;

    public Project() {
    }

    public Project(UserAccount user, Set<ProjectTask> pts, String title, String dt, Date dl, Priority p, Boolean concluded ){
        this.user = user;
        getProjectTasks().addAll(pts);
        this.title = title;
        this.description = dt;
        this.deadline = dl;
        this.priority = p;
        this.concluded = concluded;
    }

    public Project(Integer id, UserAccount user, String title, String description, Date deadline, Priority priority, Boolean concluded ) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.concluded = concluded;
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

    public Boolean getConcluded() {
        return concluded;
    }

    public void setConcluded(Boolean concluded) {
        this.concluded = concluded;
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
                ", user=" + user +
                ", projectTasks=" + projectTasks +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }
}
