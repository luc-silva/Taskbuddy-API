package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.dto.request.UserAccountRequestDTO;
import com.lucsilva.taskbuddy.dto.response.ProjectResponseDTO;
import com.lucsilva.taskbuddy.dto.response.TodoResponseDTO;
import com.lucsilva.taskbuddy.dto.response.UserResponseDTO;
import com.lucsilva.taskbuddy.dto.response.UserStatusDTO;
import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.UserStatus;
import com.lucsilva.taskbuddy.services.ProjectService;
import com.lucsilva.taskbuddy.services.TodoService;
import com.lucsilva.taskbuddy.services.UserService;
import com.lucsilva.taskbuddy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody UserAccountRequestDTO userDto) {
        userService.createAccount(userDto.convertToObject());
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserAccountRequestDTO credentialsDto) {
        UserAccount user = userService.getAccountByEmailAndValidate(credentialsDto.convertToObject());
        return ResponseEntity.ok().body(UserResponseDTO.convertToDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Integer id){
        UserAccount user = userService.getUserById(id);
        return ResponseEntity.ok().body(UserResponseDTO.convertToDto(user));
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<Set<ProjectResponseDTO>> getUserProjects(@PathVariable Integer id){
        Set<Project> projects = userService.listUserProjects(id);
        return ResponseEntity.ok().body(ProjectResponseDTO.convertSetToDto(projects));
    }

    @GetMapping("/{id}/todos")
    public ResponseEntity<Set<TodoResponseDTO>> getUserTodos(@PathVariable Integer id){
        Set<Todo> todos = userService.listUserTodos(id);
        return ResponseEntity.ok().body(TodoResponseDTO.convertSetToDto(todos));
    }

    @GetMapping("/{id}/todos/important")
    public ResponseEntity<Set<TodoResponseDTO>> getUserImportantTodos(@PathVariable Integer id){
        Set<Todo> todos = userService.getImportantTodos(id);
        return ResponseEntity.ok().body(TodoResponseDTO.convertSetToDto(todos));
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<UserStatusDTO> getUserStatus(@PathVariable Integer id){
        UserStatus status = userService.getUserStatus(id);
        return ResponseEntity.ok().body(UserStatusDTO.convertToDTO(status));
    }

}
