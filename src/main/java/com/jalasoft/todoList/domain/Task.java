package com.jalasoft.todoList.domain;

import com.jalasoft.todoList.database.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class Task {

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
