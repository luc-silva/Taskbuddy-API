package com.lucsilva.taskbuddy.dto.request;

import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.util.Date;

public class TodoRequestDTO {
    String text;
    Boolean concluded;
    Date deadline;
    Priority priority;
    UserAccountRequestDTO user;

    public TodoRequestDTO(){}
    public TodoRequestDTO(String text, Boolean concluded, Date deadline, Priority priority, UserAccountRequestDTO user){
        this.text = text;
        this.concluded = concluded;
        this.deadline = deadline;
        this.priority = priority;
        this.user = user;
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

    public UserAccountRequestDTO getUser() {
        return user;
    }

    public void setUser(UserAccountRequestDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TodoRequestDTO{" +
                "text='" + text + '\'' +
                ", concluded=" + concluded +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", user=" + user +
                '}';
    }
}
