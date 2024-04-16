package com.goldeng.todoapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldeng.todoapp.model.Task;
import com.goldeng.todoapp.model.User;
import com.goldeng.todoapp.model.dtos.task.TaskDto;
import com.goldeng.todoapp.model.mappers.TaskMapper;
import com.goldeng.todoapp.repository.TaskRepository;
import com.goldeng.todoapp.repository.UserRepository;
import com.goldeng.todoapp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskRequest) {
        Task task = taskMapper.toTask(taskRequest);
        task.setCreationDate(LocalDate.now());
        
        User user = userRepository.findById(taskRequest.userId()).get();

        if (user != null) {
            task.setUser(user);
            TaskDto taskResponse = taskMapper.toTaskDto(taskRepository.save(task));
            return taskResponse;
        } else {
            return null;
        }
    }

    @Override
    public TaskDto getTask(UUID taskId) {
        return taskMapper.toTaskDto(taskRepository.findById(taskId).get());
    }

    @Override
    public List<TaskDto> getTasks() {
       return taskMapper.toTaskDtoList(taskRepository.findAll());
    }

    @Override
    public TaskDto deleteTask(UUID taskId) {
        TaskDto taskDto = this.getTask(taskId);
        Task taskToDelete = taskMapper.toTask(taskDto);
        taskRepository.delete(taskToDelete);
        return taskDto;
    }
}
