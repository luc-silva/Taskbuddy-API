package com.lucsilva.taskbuddy.entities;

public class UserStatus {
    Integer todo_total;
    Integer todo_concluded;
    Double todo_conclusion_rate;
    Integer project_total;
    Integer project_concluded;
    Double project_conclusion_rate;
    Double project_tasks_average;
    UserAccount user;


    public UserStatus() {
    }

    public UserStatus(Integer todo_total, Double todo_conclusion_rate, Integer project_total, Double project_conclusion_rate, Double project_tasks_average, UserAccount user) {
        this.todo_total = todo_total;
        this.todo_conclusion_rate = todo_conclusion_rate;
        this.project_total = project_total;
        this.project_conclusion_rate = project_conclusion_rate;
        this.project_tasks_average = project_tasks_average;
        this.user = user;
    }

    public Integer getTodo_concluded() {
        return todo_concluded;
    }

    public void setTodo_concluded(Integer todo_concluded) {
        this.todo_concluded = todo_concluded;
    }

    public Integer getProject_concluded() {
        return project_concluded;
    }

    public void setProject_concluded(Integer project_concluded) {
        this.project_concluded = project_concluded;
    }

    public Integer getTodo_total() {
        return todo_total;
    }

    public void setTodo_total(Integer todo_total) {
        this.todo_total = todo_total;
    }

    public Double getTodo_conclusion_rate() {
        return todo_conclusion_rate;
    }

    public void setTodo_conclusion_rate(Double todo_conclusion_rate) {
        this.todo_conclusion_rate = todo_conclusion_rate;
    }

    public Integer getProject_total() {
        return project_total;
    }

    public void setProject_total(Integer project_total) {
        this.project_total = project_total;
    }

    public Double getProject_conclusion_rate() {
        return project_conclusion_rate;
    }

    public void setProject_conclusion_rate(Double project_conclusion_rate) {
        this.project_conclusion_rate = project_conclusion_rate;
    }

    public Double getProject_tasks_average() {
        return project_tasks_average;
    }

    public void setProject_tasks_average(Double project_tasks_average) {
        this.project_tasks_average = project_tasks_average;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
}
