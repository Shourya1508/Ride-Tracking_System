package com.example.user.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.user.Entity.User;
import com.example.user.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // -----------------------------
    // Register a new user
    // -----------------------------
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    // -----------------------------
    // Get all users
    // -----------------------------
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }
}

