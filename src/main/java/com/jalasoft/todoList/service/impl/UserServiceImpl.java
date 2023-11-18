package com.jalasoft.todoList.service.impl;

import com.jalasoft.todoList.database.UserRepository;
import com.jalasoft.todoList.database.entity.UserEntity;
import com.jalasoft.todoList.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addUser(UserEntity user) {
        userRepository.save(user);
    }
}
