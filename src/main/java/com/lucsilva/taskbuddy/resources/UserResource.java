package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserAccount userAccount) {
        userService.createAccount(userAccount);
        return ResponseEntity.ok().body("Feito.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserAccount credentials) {
        UserAccount user = userService.getAccountByEmailAndValidate(credentials);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable String id){
        UserAccount userAccount = userService.getUserById(Integer.valueOf(id));
        return ResponseEntity.ok().body(userAccount);
    }
}
