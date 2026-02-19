package com.smartworking.taskmanager.service.addTask;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.requestDTO.AddTaskRequestDto;

public interface AddTasksService {
    public Task addNewTask(AddTaskRequestDto request);
}
