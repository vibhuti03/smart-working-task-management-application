package com.smartworking.taskmanager.service.deleteTask;

import org.springframework.http.ResponseEntity;

public interface DeleteTaskService {
    public ResponseEntity<String> deleteTaskFromId(int id);
}
