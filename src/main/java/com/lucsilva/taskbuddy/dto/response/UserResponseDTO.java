package com.lucsilva.taskbuddy.dto.response;

import com.lucsilva.taskbuddy.entities.UserAccount;

public class UserResponseDTO {
    Integer id;
    String name;
    String email;

    public UserResponseDTO(){}
    public UserResponseDTO(Integer id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserResponseDTO convertToDto(UserAccount u){
        return new UserResponseDTO(u.getId(), u.getName(), u.getEmail());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
