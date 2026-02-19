package com.smartworking.taskmanager.controller;


import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.requestDTO.AddTaskRequestDto;
import com.smartworking.taskmanager.dto.responseDTO.TaskListResponseDto;
import com.smartworking.taskmanager.service.addTask.AddTasksService;
import com.smartworking.taskmanager.service.fetchTasks.FetchAllTasksService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TaskManagerController {

    private FetchAllTasksService fetchAllTasksService;
    private AddTasksService addTasksService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(@RequestParam String name){
        return ResponseEntity.ok().body("Hello "+ name);
    }

    @GetMapping("/task")
    public TaskListResponseDto getAllTasks(){
        return fetchAllTasksService.allTaskDetails();
    }

    @PostMapping("/add-task")
    public Task addTask(
            @Valid  @RequestBody
            AddTaskRequestDto request
            ){
        return addTasksService.addNewTask(request);
    }

    @PostMapping("/task-details")
    public TaskListResponseDto taskDetails(@RequestBody int id){
        return null;
    }

    @DeleteMapping("/delete-task")
    public ResponseEntity<String> deleteTask(@RequestBody int id){
        return null;
    }


}
