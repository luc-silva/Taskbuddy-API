package com.lucsilva.taskbuddy.entities;

import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.io.Serializable;
import java.util.Objects;

public class ProjectTask implements Serializable {
    Integer id;
    String title;
    Priority priority;

    public ProjectTask(){}
    public ProjectTask(Integer id,String title, Priority priority){
        this.id = id;
        this.title = title;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectTask that = (ProjectTask) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                '}';
    }
}
