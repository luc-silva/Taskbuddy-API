package com.lucsilva.taskbuddy.dto.response;

import com.lucsilva.taskbuddy.dto.request.UserAccountRequestDTO;
import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.entities.enums.Priority;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TodoResponseDTO {
    String text;
    Boolean concluded;
    Date deadline;
    Priority priority;
    UserResponseDTO user;

    public TodoResponseDTO() {
    }

    public TodoResponseDTO(String text, Boolean concluded, Date deadline, Priority priority, UserResponseDTO user) {
        this.text = text;
        this.concluded = concluded;
        this.deadline = deadline;
        this.priority = priority;
        this.user = user;
    }

    static public TodoResponseDTO covertToDTO(Todo todo){
        UserResponseDTO user = UserResponseDTO.convertToDto(todo.getUser());
        return new TodoResponseDTO(todo.getText(), todo.getConcluded(), todo.getDeadline(), todo.getPriority(), user);
    }

    static public Set<TodoResponseDTO> convertSetToDto(Set<Todo> todos){
        Set<TodoResponseDTO> dtos = new HashSet<>();
        for(Todo todo : todos){
            dtos.add(TodoResponseDTO.covertToDTO(todo));
        }
        return dtos;
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

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TodoResponseDTO{" +
                "text='" + text + '\'' +
                ", concluded=" + concluded +
                ", deadline=" + deadline +
                ", priority=" + priority +
                ", user=" + user +
                '}';
    }
}
