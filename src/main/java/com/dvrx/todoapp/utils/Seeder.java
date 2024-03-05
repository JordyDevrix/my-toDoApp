package com.dvrx.todoapp.utils;

import com.dvrx.todoapp.dao.CategoryRepository;
import com.dvrx.todoapp.dao.TaskRepository;
import com.dvrx.todoapp.models.Category;
import com.dvrx.todoapp.models.Task;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    public Seeder(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Category category1 = new Category("school");

        this.categoryRepository.save(category1);

        Task task1 = new Task("Video's kijken", "Video colleges van springboot kijken", category1);
        Task task2 = new Task("leren", "Nog meer video colleges van springboot kijken, en er van leren", category1);

        this.taskRepository.save(task1);
        this.taskRepository.save(task2);
    }
}
