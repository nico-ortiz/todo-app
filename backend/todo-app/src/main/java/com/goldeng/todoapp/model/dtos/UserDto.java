package com.goldeng.todoapp.model.dtos;

import java.util.UUID;
import java.util.List;

public record UserDto(
    UUID id,
    String name,
    String email,
    String password,
    List<TaskDto> tasks
) {
    
}
