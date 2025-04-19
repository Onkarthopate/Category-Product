package com.CategoryProduct.CategoryProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CategoryProduct.CategoryProduct.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
