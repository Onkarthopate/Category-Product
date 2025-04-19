 package com.CategoryProduct.CategoryProduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CategoryProduct.CategoryProduct.model.Category;
import com.CategoryProduct.CategoryProduct.service.CategoryService;

@RestController 
//It is used to create RESTful web services that respond with JSON directly include Controller and response body

@RequestMapping("/api/categories") 

//connects a web URL to a specific method in your code so it can handle requests like GET or POST for that URL.

public class CategoryController {

    @Autowired // automatic inject all required dependency
    private CategoryService categoryService;

    
    // @RequestParam :  extracts query parameters from the URL
    
    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return categoryService.getAllCategories(page, size);
    }

    // @RequestBody : takes data from the request and converts it into a JSON
    
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // @PathVariable extracts values from the URL  
    
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        System.out.println("Category Deleted Succesfully!");
    }
}