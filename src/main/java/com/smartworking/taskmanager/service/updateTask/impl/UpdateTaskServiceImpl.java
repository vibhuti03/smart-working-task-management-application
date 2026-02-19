package com.smartworking.taskmanager.service.updateTask.impl;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.updateTask.UpdateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskServiceImpl implements UpdateTaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task updateTaskById(Task request) {
        TaskEntity task = taskRepository.findById(request.getId()).orElseThrow();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());
        task.setDueDate(request.getDueDate());
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
