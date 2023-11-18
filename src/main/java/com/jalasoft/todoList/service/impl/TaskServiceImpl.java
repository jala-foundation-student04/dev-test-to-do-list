package com.jalasoft.todoList.service.impl;

import com.jalasoft.todoList.converter.TaskConverter;
import com.jalasoft.todoList.database.TaskRepository;
import com.jalasoft.todoList.domain.Task;
import com.jalasoft.todoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskConverter taskConverter;

    @Override
    public Task addTask(Task task) {
        return taskConverter.convertEntityToDomain(taskRepository.save(taskConverter.convertDomainToEntity(task)));
    }

    @Override
    public Task updateTask(Task task) {
        Task taskAux = taskConverter.convertEntityToDomain(taskRepository.findById(task.getId()).orElse(null));
        if(isNull(taskAux)) {
            log.error("The task with ID {}, is not registered", nonNull(task.getId()) ? task.getId() : null);
            return task;
        }

        return taskConverter.convertEntityToDomain(taskRepository.save(taskConverter.convertDomainToEntity(task)));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskConverter.convertEntityToDomain(taskRepository.findById(id).orElse(null));
        if(nonNull(task)) {
            taskRepository.deleteById(id);
            log.info("Task with id {} was deleted succefully!", id);
        }
    }

    @Override
    public List<Task> listTasks(Long id) {
        return taskConverter.convertEntityListToDomainList(taskRepository.findAllByUserId(id));
    }





}
