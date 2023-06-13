package com.lucsilva.taskbuddy.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @ManyToOne
    UserAccount user;

    String text;
    Boolean concluded;
    Date deadline;
    Priority priority;

    public Todo() {
    }

    public Todo(Integer id, UserAccount user, String text, Boolean concluded, Date deadline, Priority priority) {
        this.id = id;
        this.user = user;
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

    public UserAccount getUser() {
        return user;
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
