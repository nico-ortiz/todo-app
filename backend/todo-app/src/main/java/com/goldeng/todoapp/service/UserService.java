package com.goldeng.todoapp.service;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.dtos.user.UserDto;
import com.goldeng.todoapp.model.dtos.user.UserRequest;
import com.goldeng.todoapp.model.dtos.user.UserResponse;

public interface UserService {
    
    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(UUID userId);

    UserDto getUserDtoById(UUID userId);

    List<UserResponse> getUsers();

    UserResponse deleteUser(UUID userId);

    UserResponse updateUser(UserDto user);

    UserResponse deleteTaskOfUser(UUID userId, UUID taskId); 

    UserResponse markTaskAsCompleted(UUID userId, UUID taskId);
}
