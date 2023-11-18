package com.jalasoft.todoList.converter.impl;

import com.jalasoft.todoList.converter.TaskConverter;
import com.jalasoft.todoList.controller.dto.TaskRequest;
import com.jalasoft.todoList.controller.dto.TaskResponse;
import com.jalasoft.todoList.database.entity.TaskEntity;
import com.jalasoft.todoList.domain.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Component
public class TaskConverterImpl implements TaskConverter {
    @Override
    public Task convertRequestToDomain(TaskRequest taskRequest) {
        if(isNull(taskRequest))
            return null;
        return Task.builder()
                .id(taskRequest.getId())
                .name(taskRequest.getName())
                .category(taskRequest.getCategory())
                .description(taskRequest.getDescription())
                .dueDate(taskRequest.getDueDate())
                .status(taskRequest.getStatus())
                .created(taskRequest.getCreated())
                .lastUpdated(taskRequest.getLastUpdated())
                .active(taskRequest.getActive())
                .user(taskRequest.getUser())
                .build();
    }

    @Override
    public TaskResponse convertDomainToResponse(Task task) {
        if(isNull(task))
            return null;
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .category(task.getCategory())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .created(task.getCreated())
                .lastUpdated(task.getLastUpdated())
                .active(task.getActive())
                .user(task.getUser())
                .build();
    }

    @Override
    public TaskEntity convertDomainToEntity(Task task) {
        if(isNull(task))
            return null;
        return TaskEntity.builder()
                .id(task.getId())
                .name(task.getName())
                .category(task.getCategory())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .created(nonNull(task.getCreated()) ? task.getCreated() : LocalDateTime.now())
                .lastUpdated(nonNull(task.getLastUpdated()) ? task.getLastUpdated() : LocalDateTime.now())
                .active(task.getActive())
                .user(task.getUser())
                .build();
    }

    @Override
    public Task convertEntityToDomain(TaskEntity taskEntity) {
        if(isNull(taskEntity))
            return null;
        return Task.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .category(taskEntity.getCategory())
                .description(taskEntity.getDescription())
                .dueDate(taskEntity.getDueDate())
                .status(taskEntity.getStatus())
                .created(taskEntity.getCreated())
                .lastUpdated(taskEntity.getLastUpdated())
                .active(taskEntity.getActive())
                .user(taskEntity.getUser())
                .build();
    }

    public List<Task> convertEntityListToDomainList(List<TaskEntity> taskEntityList) {
        if(isNull(taskEntityList) || taskEntityList.isEmpty())
            return new ArrayList<>();

        return taskEntityList.stream().filter(Objects::nonNull).map(this::convertEntityToDomain).collect(Collectors.toList());
    }

    public List<TaskResponse> convertDomainListToResponseList(List<Task> task) {
        if(isNull(task) || task.isEmpty())
            return new ArrayList<>();

        return task.stream().filter(Objects::nonNull).map(this::convertDomainToResponse).collect(Collectors.toList());
    }

}
