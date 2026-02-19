package com.smartworking.taskmanager.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Task {

    private int id;
    private String title;
    private String description;
    private  boolean isCompleted;
    private LocalDateTime dueDate;
}
