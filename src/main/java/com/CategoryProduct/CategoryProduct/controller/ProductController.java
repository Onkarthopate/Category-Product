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
import com.CategoryProduct.CategoryProduct.model.Product;
import com.CategoryProduct.CategoryProduct.service.CategoryService;
import com.CategoryProduct.CategoryProduct.service.ProductService;

@RestController

//It is used to create RESTful web services that respond with JSON directly include Controller and response body

//connects a web URL to a specific method in your code so it can handle requests like GET or POST for that URL.

@RequestMapping("/api/products")

public class ProductController {

    @Autowired  // automatic inject all required dependency
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService; 

    // @RequestParam :  extracts query parameters from the URL

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return productService.getAllProducts(page, size);
    }
    
    // @RequestBody : takes data from the request and converts it into a JSON

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

    	Category category = categoryService.getCategoryById(product.getCategory().getId());
        if (category != null) {
            product.setCategory(category); 
        } else {
                        throw new RuntimeException("Category not found");
        }
        return productService.saveProduct(product);
    }

    // @PathVariable extracts values from the URL  

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}