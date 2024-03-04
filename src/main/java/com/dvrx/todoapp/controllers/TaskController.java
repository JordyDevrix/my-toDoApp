package com.dvrx.todoapp.controllers;

import com.dvrx.todoapp.dao.TaskDAO;
import com.dvrx.todoapp.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskDAO taskDAO;

    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return this.taskDAO.getAllTasks();
    }

}
