package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.entity.ProductEntity;
import com.ecommerce.project.request.ProductRequest;
import com.ecommerce.project.response.ProductResponse;
import com.ecommerce.project.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;

	@PostMapping("/add")
	public ProductResponse addProduct(@RequestBody ProductRequest req) {
		return productservice.addProduct(req);
	}
	
	@GetMapping("/all")
	public List<ProductEntity> findAllProduct(){ 
		return productservice.findAllProduct();
	}
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody ProductRequest product) {
		return productservice.updateProduct(id, product);
	}

}
