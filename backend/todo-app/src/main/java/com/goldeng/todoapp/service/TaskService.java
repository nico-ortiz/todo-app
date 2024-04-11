package com.goldeng.todoapp.service;

import java.util.List;
import java.util.UUID;

import com.goldeng.todoapp.model.Task;

public interface TaskService {

    Task createTask(Task task);

    Task getTask(UUID taskId);

    List<Task> getTasks();
}
