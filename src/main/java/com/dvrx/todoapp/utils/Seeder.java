package com.dvrx.todoapp.utils;

import com.dvrx.todoapp.dao.TaskRepository;
import com.dvrx.todoapp.models.Task;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private TaskRepository taskRepository;

    public Seeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Task task1 = new Task("Video's kijken", "Video colleges van springboot kijken");
        Task task2 = new Task("leren", "Nog meer video colleges van springboot kijken, en er van leren");

        this.taskRepository.save(task1);
        this.taskRepository.save(task2);
    }
}
