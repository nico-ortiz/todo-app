package com.goldeng.todoapp.service;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.dtos.task.TaskDto;

public interface TaskService {

    TaskDto createTask(TaskDto task);

    TaskDto getTask(UUID taskId);

    List<TaskDto> getTasks();

    TaskDto deleteTask(UUID taskId);
}
