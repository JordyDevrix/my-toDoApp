package com.dvrx.todoapp.dao;

import com.dvrx.todoapp.dto.CategoryDTO;
import com.dvrx.todoapp.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO {

    private CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.name);
        this.categoryRepository.save(category);
    }
}
