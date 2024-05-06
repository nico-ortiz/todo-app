package com.goldeng.todoapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldeng.todoapp.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
