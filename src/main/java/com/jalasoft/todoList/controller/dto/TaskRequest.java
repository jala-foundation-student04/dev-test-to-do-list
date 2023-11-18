package com.jalasoft.todoList.controller.dto;

import com.jalasoft.todoList.database.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskRequest {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private String category;
    private String status;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private Boolean active;
    private UserEntity user;
}
