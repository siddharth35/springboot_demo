package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		ResponseEntity<Product> productResponse = new ResponseEntity<>(service.saveProduct(product),
				HttpStatus.CREATED);
		return productResponse;
	}

	@GetMapping("/products/all")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable("pid") int productId) {
		return service.getProduct(productId);
	}

	@GetMapping("products/delete/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("pid") int productId) {
		ResponseEntity<Product> productResponse = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		if (service.exist(productId)) {
			service.deleteProduct(productId);
			productResponse = new ResponseEntity<Product>(HttpStatus.OK);
		}
		return productResponse;
	}
}
