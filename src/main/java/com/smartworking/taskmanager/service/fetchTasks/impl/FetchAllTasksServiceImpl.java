package com.smartworking.taskmanager.service.fetchTasks.impl;

import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.responseDTO.TaskListResponseDto;
import com.smartworking.taskmanager.entity.TaskEntity;
import com.smartworking.taskmanager.repository.TaskRepository;
import com.smartworking.taskmanager.service.fetchTasks.FetchAllTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchAllTasksServiceImpl implements FetchAllTasksService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskListResponseDto allTaskDetails() {
        List<TaskEntity> tasks =  taskRepository.findAll();

        List<Task> taskList = tasks.stream()
                .map(task -> Task.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .isCompleted(task.isCompleted())
                        .dueDate(task.getDueDate())
                        .build())
                .toList();

        return new TaskListResponseDto(taskList);
    }
}
