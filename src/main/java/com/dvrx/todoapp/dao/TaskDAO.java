package com.dvrx.todoapp.dao;

import com.dvrx.todoapp.models.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDAO {

    private TaskRepository taskRepository;

    public TaskDAO(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = this.taskRepository.findAll();
        return tasks;
    }
}
