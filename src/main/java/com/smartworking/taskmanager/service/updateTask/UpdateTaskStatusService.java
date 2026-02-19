package com.smartworking.taskmanager.service.updateTask;

import com.smartworking.taskmanager.dto.Task;

public interface UpdateTaskStatusService {
    public Task updateTaskCompletedStatus(int id, boolean newStatus);
}
