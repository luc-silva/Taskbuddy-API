package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserAccount userAccount) {
        userService.createAccount(userAccount);
        return ResponseEntity.ok().body("Done.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserAccount credentials) {
        UserAccount user = userService.getAccountByEmailAndValidate(credentials);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable Integer id){
        UserAccount userAccount = userService.getUserById(id);
        return ResponseEntity.ok().body(userAccount);
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<Set<Project>> getUserProjects(@PathVariable Integer id){
        Set<Project> projects = userService.listUserProjects(id);
        return ResponseEntity.ok().body(projects);
    }

    @GetMapping("/{id}/todos")
    public ResponseEntity<Set<Todo>> getUserTodos(@PathVariable Integer id){
        Set<Todo> todos = userService.listUserTodos(id);
        return ResponseEntity.ok().body(todos);
    }
}
