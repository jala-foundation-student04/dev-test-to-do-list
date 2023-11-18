package com.jalasoft.todoList.database.entity;

import com.jalasoft.todoList.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @Column(name = "cod_task", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private String category;
    private String status;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "cod_user", nullable = false)
    private UserEntity user;
}
