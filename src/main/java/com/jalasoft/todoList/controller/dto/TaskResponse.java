package com.jalasoft.todoList.controller.dto;

import com.jalasoft.todoList.database.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
@Builder
@Data
@EqualsAndHashCode
public class TaskResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private String category;
    private String status;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private Boolean active;
    private UserResponse user;
}
