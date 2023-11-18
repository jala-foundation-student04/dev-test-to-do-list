package com.jalasoft.todoList.database;

import com.jalasoft.todoList.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
