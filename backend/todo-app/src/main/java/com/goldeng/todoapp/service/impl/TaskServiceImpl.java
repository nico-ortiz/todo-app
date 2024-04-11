package com.goldeng.todoapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldeng.todoapp.model.Task;
import com.goldeng.todoapp.repository.TaskRepository;
import com.goldeng.todoapp.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTask(UUID taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public List<Task> getTasks() {
       return taskRepository.findAll();
    }
    
}
