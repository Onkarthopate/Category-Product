package com.CategoryProduct.CategoryProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CategoryProduct.CategoryProduct.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}