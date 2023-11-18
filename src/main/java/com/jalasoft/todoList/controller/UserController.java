package com.jalasoft.todoList.controller;

import com.jalasoft.todoList.database.entity.UserEntity;
import com.jalasoft.todoList.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity addTask(@RequestBody UserEntity userEntity) {
        userService.addUser(userEntity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
