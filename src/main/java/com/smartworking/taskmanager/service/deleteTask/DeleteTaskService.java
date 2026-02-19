package com.smartworking.taskmanager.service.deleteTask;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.requestDTO.AddTaskRequestDto;
import org.springframework.http.ResponseEntity;

public interface DeleteTaskService {
    public ResponseEntity<String> deleteTaskFromId(int id);
}
