package com.goldeng.todoapp.model.dtos.user;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.dtos.task.TaskWithoutUser;

public record UserResponse(
    UUID id,
    String name,
    String email,
    List<TaskWithoutUser> tasks
) {
    
}
