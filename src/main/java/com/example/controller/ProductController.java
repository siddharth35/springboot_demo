package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService service;

	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@GetMapping("/products/all")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable("pid") int pid) {
		return service.getProduct(pid);
	}
}
