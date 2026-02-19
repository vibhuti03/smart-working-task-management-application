package com.smartworking.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Task")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "isCompleted")
    private boolean isCompleted;

    @Column(name = "dueDate")
    private LocalDateTime dueDate;
}
