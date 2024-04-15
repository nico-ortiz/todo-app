package com.goldeng.todoapp.model.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.goldeng.todoapp.model.User;
import com.goldeng.todoapp.model.dtos.user.UserDto;
import com.goldeng.todoapp.model.dtos.user.UserRequest;
import com.goldeng.todoapp.model.dtos.user.UserResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = TaskMapper.class)
public interface UserMapper {
    
    UserResponse toUserResponse(User user);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "tasks", ignore = true)
    })
    User toUser(UserRequest userRequest);

    List<UserResponse> toUserResponseList(List<User> users);

    List<User> toUserList(List<UserDto> usersDto);
}
