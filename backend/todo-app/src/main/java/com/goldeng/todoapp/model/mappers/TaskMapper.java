package com.goldeng.todoapp.model.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.goldeng.todoapp.model.Task;
import com.goldeng.todoapp.model.dtos.task.TaskDto;
import com.goldeng.todoapp.model.dtos.task.TaskWithoutUser;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    
    @Mapping(source = "user.id", target = "userId")
    TaskDto toTaskDto(Task task);

    TaskWithoutUser toTaskWithoutUser(Task task);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "creationDate", ignore = true),
        @Mapping(source = "userId", target = "user.id")
    })
    Task toTask(TaskDto taskDto);

    List<TaskDto> toTaskDtoList(List<Task> taskList);

    List<Task> toTaskList(List<TaskDto> taskDtoList);

}
