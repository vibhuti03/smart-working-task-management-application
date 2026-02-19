package com.smartworking.taskmanager.service.deleteTask.impl;

import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.deleteTask.DeleteTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DeleteTasksServiceImpl implements DeleteTaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ResponseEntity<String> deleteTaskFromId(int id) {
        try {
            Optional<TaskEntity> taskEntity = taskRepository.findById(id);

            if (taskEntity.isEmpty()) {
                return ResponseEntity.status(404).body("Task not found");
            }

            taskRepository.delete(taskEntity.get());

            return ResponseEntity.ok("Task deleted");

        } catch (Exception e) {
            log.error("Error deleting task", e);
            return ResponseEntity.internalServerError().body("Exception occurred");
        }
    }
}
