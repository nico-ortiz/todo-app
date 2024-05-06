package com.goldeng.todoapp.model.dtos.user;

public record UserRequest(
    String name,
    String email,
    String password
) {
    
}
