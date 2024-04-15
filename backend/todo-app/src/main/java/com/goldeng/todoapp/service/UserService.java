package com.goldeng.todoapp.service;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.dtos.user.UserDto;
import com.goldeng.todoapp.model.dtos.user.UserRequest;
import com.goldeng.todoapp.model.dtos.user.UserResponse;

public interface UserService {
    
    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(UUID id);

    List<UserResponse> getUsers();

    UserDto deleteUser(UUID id);

    UserDto updateUser(UserDto user);
}
