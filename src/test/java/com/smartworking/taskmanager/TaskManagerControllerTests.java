package com.smartworking.taskmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartworking.taskmanager.controller.TaskManagerController;
import com.smartworking.taskmanager.dto.Task;
import com.smartworking.taskmanager.dto.responseDTO.TaskListResponseDto;
import com.smartworking.taskmanager.service.addTask.AddTasksService;
import com.smartworking.taskmanager.service.deleteTask.DeleteTaskService;
import com.smartworking.taskmanager.service.fetchTasks.FetchAllTasksService;
import com.smartworking.taskmanager.service.taskDetails.TaskDetailService;
import com.smartworking.taskmanager.service.updateTask.UpdateTaskService;
import com.smartworking.taskmanager.service.updateTask.UpdateTaskStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TaskManagerController.class)
class TaskManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FetchAllTasksService fetchAllTasksService;

    @MockitoBean
    private AddTasksService addTasksService;

    @MockitoBean
    private TaskDetailService taskDetailService;

    @MockitoBean
    private UpdateTaskService updateTaskService;

    @MockitoBean
    private DeleteTaskService deleteTaskService;

    @MockitoBean
    private UpdateTaskStatusService updateTaskStatusService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAllTasks() throws Exception {

        Task task = Task.builder()
                .id(1)
                .title("Test Task")
                .description("Test Desc")
                .dueDate(LocalDateTime.now())
                .isCompleted(false)
                .build();

        TaskListResponseDto response =
                new TaskListResponseDto(List.of(task));

        when(fetchAllTasksService.allTaskDetails())
                .thenReturn(response);

        mockMvc.perform(get("/api/v1/task"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskList[0].title").value("Test Task"));
    }

    @Test
    void shouldDeleteTask() throws Exception {

        when(deleteTaskService.deleteTaskFromId(1))
                .thenReturn(ResponseEntity.ok("Task deleted"));

        mockMvc.perform(delete("/api/v1/delete-task?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Task deleted"));
    }
}
