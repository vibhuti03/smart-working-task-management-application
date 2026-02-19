package com.smartworking.taskmanager.service.addTask.impl;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.requestDTO.AddTaskRequestDto;
import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.addTask.AddTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddTasksServiceImpl implements AddTasksService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addNewTask(AddTaskRequestDto request) {
        TaskEntity taskEntity = TaskEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .isCompleted(request.isCompleted())
                .dueDate(request.getDueDate())
                .build();
        taskRepository.save(taskEntity);
        return Task.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .isCompleted(taskEntity.isCompleted())
                .dueDate(taskEntity.getDueDate())
                .build();
    }
}
