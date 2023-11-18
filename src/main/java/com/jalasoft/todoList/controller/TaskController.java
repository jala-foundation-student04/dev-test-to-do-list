package com.jalasoft.todoList.controller;

import com.jalasoft.todoList.controller.dto.TaskRequest;
import com.jalasoft.todoList.controller.dto.TaskResponse;
import com.jalasoft.todoList.converter.TaskConverter;
import com.jalasoft.todoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskConverter taskConverter;
    private final TaskService taskService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addTask(@RequestBody TaskRequest taskRequest) {
        taskService.addTask(taskConverter.convertRequestToDomain(taskRequest));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TaskResponse>> taskList(@RequestParam(name = "id-user") Long idUser) {

        return ResponseEntity.status(HttpStatus.OK).body(taskConverter.convertDomainListToResponseList(taskService.listTasks(idUser)));
    }

    @DeleteMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteTask(Long idTask) {

        return ResponseEntity.status(HttpStatus.OK).body(taskConverter.convertDomainListToResponseList(taskService.listTasks(idTask)));
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TaskResponse> updateTask(TaskRequest taskRequest) {

        TaskResponse taskResponse = taskConverter.convertDomainToResponse(taskService.updateTask(taskConverter.convertRequestToDomain(taskRequest)));

        if(isNull(taskResponse))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

//    @PutMapping(name = "{idUser}",consumes = "application/json", produces = "application/json")
//    public ResponseEntity<TaskResponse> updateTask(TaskRequest taskRequest) {
//
//        TaskResponse taskResponse = taskConverter.convertDomainToResponse(taskService.updateTask(taskConverter.convertRequestToDomain(taskRequest)));
//
//        if(isNull(taskResponse))
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
//    }
}
