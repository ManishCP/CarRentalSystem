package com.csye6220.carrentalsystem.controller;

/**
* @author manish 
* UserController
* handle user-related requests (registration, login, profile updates)
*/

import com.csye6220.carrentalsystem.dao.UserDAO;
import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @GetMapping("/{userID}")
    public ResponseEntity<User> getUserById(@PathVariable int userID) {
        User user = userService.getUserByID(userID);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{userID}")
    public ResponseEntity<String> updateUser(@PathVariable int userID, @RequestBody User updatedUser) {
        User existingUser = userService.getUserByID(userID);
        if (existingUser != null) {
            updatedUser.setUserID(userID);
            userService.update(updatedUser);
            return ResponseEntity.ok("User updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<String> deleteUser(@PathVariable int userID) {
        User existingUser = userService.getUserByID(userID);
        if (existingUser != null) {
            userService.delete(userID);
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
}
