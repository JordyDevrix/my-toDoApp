package com.dvrx.todoapp.controllers;

import com.dvrx.todoapp.dao.TaskDAO;
import com.dvrx.todoapp.dto.TaskDTO;
import com.dvrx.todoapp.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskDAO.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
        this.taskDAO.createTask(taskDTO);
        return ResponseEntity.ok("gelukt");
    }

}
