package com.lucsilva.taskbuddy.dto.response;

public class UserStatusDTO {
    Integer todo_total;
    Double todo_conclusion_rate;
    Integer project_total;
    Double project_conclusion_rate;
    Double project_tasks_average;

    public UserStatusDTO(){}

    public UserStatusDTO(Integer todo_total, Double todo_conclusion_rate, Integer project_total, Double project_conclusion_rate, Double project_tasks_average){
        this.todo_total = todo_total;
        this.todo_conclusion_rate = todo_conclusion_rate;
        this.project_total = project_total;
        this.project_conclusion_rate = project_conclusion_rate;
        this.project_tasks_average = project_tasks_average;
    }

    public static UserStatusDTO convertToDTO(){
        return new UserStatusDTO();
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
}