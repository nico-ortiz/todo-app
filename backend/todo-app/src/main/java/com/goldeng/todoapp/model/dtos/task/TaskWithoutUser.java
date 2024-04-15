package com.goldeng.todoapp.model.dtos.task;

import java.time.LocalDate;
import java.util.UUID;

public record TaskWithoutUser(
    UUID id,
    String description,
    String status,
    LocalDate creationDate
) {
    
}
