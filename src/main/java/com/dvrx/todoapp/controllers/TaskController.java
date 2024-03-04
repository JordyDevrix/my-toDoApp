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

    @GetMapping("/get")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskDAO.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createTask(@RequestBody TaskDTO taskDTO) {
        this.taskDAO.createTask(taskDTO);
        return ResponseEntity.ok("gelukt");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTask(@PathVariable long id, @RequestBody TaskDTO taskDTO) {
        this.taskDAO.updateTaskById(id, taskDTO);
        return ResponseEntity.ok("updated task with id " + id);
    }

    @PutMapping("/check/{id}")
    public ResponseEntity<String> checkTask(@PathVariable long id) {
        this.taskDAO.checkTask(id);
        return ResponseEntity.ok("Finished task with id " + id);
    }

    @PutMapping("/uncheck/{id}")
    public ResponseEntity<String> uncheckTask(@PathVariable long id) {
        this.taskDAO.uncheckTask(id);
        return ResponseEntity.ok("Unfinished task with id " + id);
    }

}
