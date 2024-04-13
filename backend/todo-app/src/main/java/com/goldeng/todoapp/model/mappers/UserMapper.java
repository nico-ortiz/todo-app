package com.goldeng.todoapp.model.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.goldeng.todoapp.model.User;
import com.goldeng.todoapp.model.dtos.UserDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = TaskMapper.class)
public interface UserMapper {
    
    @Mapping(target = "password", ignore = true)
    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    User toUser(UserDto userDto);

    List<UserDto> toUserDtoList(List<User> users);

    List<User> toUserList(List<UserDto> usersDto);
}
