package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Product;
import com.example.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	ProductRepo repo;

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	public Product getProduct(int productId) {
		return repo.getOne(productId);
	}
	
	public void deleteProduct(int productId) {
		repo.deleteById(productId);
	}
}
