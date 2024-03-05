package com.dvrx.todoapp.dao;

import com.dvrx.todoapp.dto.CategoryDTO;
import com.dvrx.todoapp.dto.TaskDTO;
import com.dvrx.todoapp.models.Category;
import com.dvrx.todoapp.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDAO {

    private TaskRepository taskRepository;

    private CategoryRepository categoryRepository;

    public TaskDAO(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = this.taskRepository.findAll();
        return tasks;
    }

    public void createTask(TaskDTO taskDTO) {
        // we gaan de category ophalen aan de hand van het gegeven ID in de taskDTO
        // checken of category met dat ID wel bestaat
        // Bestaat niet? > Gooit error
        // Bestaat wel? > Nieuwe taak aanmaken met category
        // schrijf de taak weg naar de database
        Optional<Category> optionalCategory = this.categoryRepository.findById(taskDTO.categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            Task task = new Task(taskDTO.name, taskDTO.description, category);
            this.taskRepository.save(task);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Categorie bestaat niet"
            );
        }
    }

    public void updateTaskById(long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            updatedTask.setName(taskDTO.name);
            updatedTask.setDescription(taskDTO.description);
            this.taskRepository.save(updatedTask);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foutmelding, taak bestaat niet");
        }
    }

    public void checkTask(long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        TaskDryer task = new TaskDryer(optionalTask, taskRepository, true);
        task.updateTask();
    }

    public void uncheckTask(long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        TaskDryer task = new TaskDryer(optionalTask, taskRepository, false);
        task.updateTask();
    }
}
