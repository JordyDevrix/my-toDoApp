package com.dvrx.todoapp.dao;

import com.dvrx.todoapp.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class TaskDryer {

    private boolean setStatus;
    private Optional<Task> optionalTask;
    private TaskRepository taskRepository;

    public TaskDryer(Optional<Task> optionalTask, TaskRepository taskRepository, boolean setStatus) {
        this.optionalTask = optionalTask;
        this.taskRepository = taskRepository;
        this.setStatus = setStatus;
    }

    public void updateTask() {
        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            updatedTask.setFinished(setStatus);
            this.taskRepository.save(updatedTask);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foutmelding, taak bestaat niet");
        }
    }
}
