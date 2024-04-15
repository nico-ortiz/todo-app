package com.goldeng.todoapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.goldeng.todoapp.model.Task;
import com.goldeng.todoapp.model.User;
import com.goldeng.todoapp.model.dtos.user.UserDto;
import com.goldeng.todoapp.model.dtos.user.UserRequest;
import com.goldeng.todoapp.model.dtos.user.UserResponse;
import com.goldeng.todoapp.model.mappers.UserMapper;
// import com.goldeng.todoapp.model.mappers.UserMapper;
import com.goldeng.todoapp.repository.UserRepository;
import com.goldeng.todoapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
 
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setTasks(new ArrayList<>());
        UserResponse userResponse = userMapper.toUserResponse(userRepository.save(user));
        return userResponse;
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        return userMapper.toUserResponse(userRepository.findById(userId).orElse(null));
    }

    @Override
    public UserDto getUserDtoById(UUID userId) {
        return userMapper.toUserDto(userRepository.findById(userId).orElse(null));
    }

    @Override
    public List<UserResponse> getUsers() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse deleteUser(UUID userId) {
        User userToDelete = userMapper.toUser(this.getUserDtoById(userId));
        userRepository.delete(userToDelete);
        return userMapper.toUserResponse(userToDelete);
    }

    @Override
    public UserResponse updateUser(UserDto user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public UserResponse deleteTaskOfUser(UUID userId, UUID taskId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        List<Task> tasks = user.getTasks();
        
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(taskId)) {
                tasks.remove(i);
                user.setTasks(tasks);
                UserResponse userResponse = userMapper.toUserResponse(userRepository.save(user));
                return userResponse;
            }
        }
        return null;
    }  
}
