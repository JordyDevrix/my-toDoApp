package com.dvrx.todoapp.dao;

import com.dvrx.todoapp.dto.TaskDTO;
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

    public void createTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.name, taskDTO.description);
        this.taskRepository.save(task);
    }
}
