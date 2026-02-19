package com.smartworking.taskmanager.dto.responseDTO;

import com.smartworking.taskmanager.dto.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class TaskListResponseDto {
    private List<Task> taskList;
}
