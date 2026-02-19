package com.smartworking.taskmanager.service.updateTask;

import com.smartworking.taskmanager.dto.Task;

public interface UpdateTaskService {
    public Task updateTaskById(Task request);
}
