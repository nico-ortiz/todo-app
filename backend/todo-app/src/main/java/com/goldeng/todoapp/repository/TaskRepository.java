package com.goldeng.todoapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldeng.todoapp.model.Task;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    
}