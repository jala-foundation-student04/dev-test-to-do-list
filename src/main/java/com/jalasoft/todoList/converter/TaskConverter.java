package com.jalasoft.todoList.converter;

import com.jalasoft.todoList.controller.dto.TaskRequest;
import com.jalasoft.todoList.controller.dto.TaskResponse;
import com.jalasoft.todoList.database.entity.TaskEntity;
import com.jalasoft.todoList.domain.Task;

import java.util.List;

public interface TaskConverter {
    Task convertRequestToDomain(TaskRequest taskRequest);
    TaskResponse convertDomainToResponse(Task task);
    TaskEntity convertDomainToEntity(Task task);
    Task convertEntityToDomain(TaskEntity taskEntity);
    List<Task> convertEntityListToDomainList(List<TaskEntity> taskEntityList);
    List<TaskResponse> convertDomainListToResponseList(List<Task> task);

}
