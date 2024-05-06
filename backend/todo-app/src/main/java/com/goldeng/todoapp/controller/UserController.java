package com.goldeng.todoapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldeng.todoapp.model.dtos.user.UserRequest;
import com.goldeng.todoapp.model.dtos.user.UserResponse;
import com.goldeng.todoapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponse> getUsers(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    
    @PutMapping("{userId}/tasks/{taskId}")
    public ResponseEntity<UserResponse> removeTask(
            @PathVariable UUID userId,
            @PathVariable UUID taskId) {
        return ResponseEntity.ok(userService.deleteTaskOfUser(userId, taskId));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @PutMapping("{userId}/tasks/completedTask/{taskId}")
    public ResponseEntity<UserResponse> markTaskAsCompleted(
            @PathVariable UUID userId,
            @PathVariable UUID taskId) {
        return ResponseEntity.ok(userService.markTaskAsCompleted(userId, taskId));
    }
}
