package com.goldeng.todoapp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldeng.todoapp.model.dtos.task.TaskDto;
import com.goldeng.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/tasks")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable UUID taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    } 

    @PostMapping("")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto request) {
        return ResponseEntity.ok(taskService.createTask(request));
    }

    @GetMapping("")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    } 

    @DeleteMapping("{taskId}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable UUID taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }
    
}
