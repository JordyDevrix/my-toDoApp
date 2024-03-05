package com.dvrx.todoapp.controllers;

import com.dvrx.todoapp.dao.CategoryDAO;
import com.dvrx.todoapp.dto.CategoryDTO;
import com.dvrx.todoapp.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryDAO categoryDAO;

    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(this.categoryDAO.getAllCategories());
    }

    @PostMapping
    public  ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        this.categoryDAO.createCategory(categoryDTO);
        return ResponseEntity.ok("New category created");
    }

}
