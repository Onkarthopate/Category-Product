package com.CategoryProduct.CategoryProduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.CategoryProduct.CategoryProduct.model.Category;
import com.CategoryProduct.CategoryProduct.repository.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	
	private CategoryRepository categoryRepository ;
	
	public Page<Category> getAllCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }
	
	public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
	
}

    
