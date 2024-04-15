package com.goldeng.todoapp.model.dtos.user;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.dtos.task.TaskDto;

public record UserDto(
    UUID id,
    String name,
    String email,
    String password,
    List<TaskDto> tasks
) {
    
}
