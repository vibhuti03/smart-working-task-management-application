package com.smartworking.taskmanager.controller;


import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.requestDTO.AddTaskRequestDto;
import com.smartworking.taskmanager.dto.responseDTO.TaskListResponseDto;
import com.smartworking.taskmanager.service.addTask.AddTasksService;
import com.smartworking.taskmanager.service.deleteTask.DeleteTaskService;
import com.smartworking.taskmanager.service.fetchTasks.FetchAllTasksService;
import com.smartworking.taskmanager.service.taskDetails.TaskDetailService;
import com.smartworking.taskmanager.service.updateTask.UpdateTaskStatusService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TaskManagerController {

    private FetchAllTasksService fetchAllTasksService;
    private AddTasksService addTasksService;
    private TaskDetailService taskDetailService;
    private DeleteTaskService deleteTaskService;
    private UpdateTaskStatusService updateTaskStatusService;

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
    public Task taskDetails(@RequestParam  int id){
        return taskDetailService.getTaskDetail(id);
    }

    @DeleteMapping("/delete-task")
    public ResponseEntity<String> deleteTask(@RequestParam  int id){
        return deleteTaskService.deleteTaskFromId(id);
    }

    @PostMapping("/update-task-status")
    public Task updateTaskStatus(@RequestParam  int id, @RequestParam boolean newStatus){
        return updateTaskStatusService.updateTaskCompletedStatus(id,newStatus);
    }


}
