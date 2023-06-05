package com.lucsilva.taskbuddy.entities;


import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Todo implements Serializable {
    Integer id;
    String text;
    Boolean concluded;
    Date deadline;
    Priority priority;
    public Todo(){}
    public  Todo(Integer id, String text, Boolean concluded, Date deadline, Priority priority){
        this.id = id;
        this.text = text;
        this.concluded = concluded;
        this.deadline = deadline;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getConcluded() {
        return concluded;
    }

    public void setConcluded(Boolean concluded) {
        this.concluded = concluded;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", concluded=" + concluded +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }
}
