package com.CategoryProduct.CategoryProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // enables component scanning, auto-configuration,
public class CategoryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryProductApplication.class, args);
		System.out.println("Application run properly..");
	}

}
