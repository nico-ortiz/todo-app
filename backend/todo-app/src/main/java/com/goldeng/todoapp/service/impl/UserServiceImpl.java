package com.goldeng.todoapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

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
    public UserResponse getUserById(UUID id) {
        return userMapper.toUserResponse(userRepository.findById(id).get());
    }

    @Override
    public List<UserResponse> getUsers() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    @Override
    public UserDto deleteUser(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public UserDto updateUser(UserDto user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
    
}
