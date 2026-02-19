package com.smartworking.taskmanager.service.updateTask.impl;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.updateTask.UpdateTaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateTaskStatusServiceImpl implements UpdateTaskStatusService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task updateTaskCompletedStatus(int id, boolean newStatus) {
        TaskEntity task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(newStatus);
        taskRepository.save(task);
        return Task.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .isCompleted(task.isCompleted())
                .dueDate(task.getDueDate())
                .build();
    }
}
