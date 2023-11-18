package com.jalasoft.todoList.service;

import com.jalasoft.todoList.domain.Task;

import java.util.List;

public interface TaskService {

    Task addTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long id);
    List<Task> listTasks(Long id);
//    Task getTask(Long id);


}
