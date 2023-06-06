package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import com.lucsilva.taskbuddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserAccount userAccount) {
        userService.createAccount(userAccount);
        return ResponseEntity.ok().body("Feito.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserAccount credentials) {
        UserAccount user = userService.getAccountByEmail(credentials.getEmail());
        if (user == null) {
            return ResponseEntity.status(404).body("User not found.");
        }
        if(!(user.getPassword().equals(credentials.getPassword()))){
            return ResponseEntity.status(401).body("Wrong password.");
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable String id){
        UserAccount userAccount = userService.getUserById(Integer.valueOf(id));
        if(userAccount == null){
            return ResponseEntity.ok().body("Deu bem errado");
        }
        return ResponseEntity.ok().body(userAccount);
    }
}
