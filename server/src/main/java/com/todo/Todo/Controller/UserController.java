package com.todo.Todo.Controller;


import com.todo.Todo.Entitiy.UserEntity;
import com.todo.Todo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
        // Validate input
        if (user.getEmail() == null || user.getUserName() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Please fill all the required fields correctly.");
        }
        // Call service and return the response
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        // Fetch all users and return the response
        List<UserEntity> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user, @PathVariable Long userId) {
        // Validate input
        if (user.getEmail() == null || user.getUserName() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().body("Please fill all the required fields correctly.");
        }
        // Call service and return the updated user
        return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        // Delete user and return a success message
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getSingle/{userId}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long userId) {
        // Fetch the user by ID
        UserEntity user = userService.getUser(userId);

        // Create a response map
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User found");
        response.put("user", user);

        // Return the response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}




