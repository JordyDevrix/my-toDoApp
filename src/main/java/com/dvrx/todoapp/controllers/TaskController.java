package com.dvrx.todoapp.controllers;

import com.dvrx.todoapp.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public Task getTask() {
        Task myTask = new Task("video colleges kijken", "Springboot videocolleges kijken en ervan leren");
        return myTask;
    }

}
