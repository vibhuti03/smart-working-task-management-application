package com.smartworking.taskmanager.dto.requestDTO;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class AddTaskRequestDto {

    private String title;
    private String description;
    private  boolean isCompleted;
    private LocalDateTime dueDate;
}

