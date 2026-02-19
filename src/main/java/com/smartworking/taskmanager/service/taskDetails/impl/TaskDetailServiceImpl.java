package com.smartworking.taskmanager.service.taskDetails.impl;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.taskDetails.TaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskDetailServiceImpl implements TaskDetailService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getTaskDetail(int id) {

        Optional<TaskEntity> taskEntity = taskRepository.findById(id);
        return taskEntity.stream().
                findFirst()
                .map(task -> Task.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .isCompleted(task.isCompleted())
                        .dueDate(task.getDueDate())
                        .build())
                .orElse(null);
    }
}
