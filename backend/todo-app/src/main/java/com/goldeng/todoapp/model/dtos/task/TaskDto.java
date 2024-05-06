package com.goldeng.todoapp.model.dtos.task;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
    UUID id,
    String description,
    String status,
    LocalDate creationDate,
    UUID userId
) {
} 