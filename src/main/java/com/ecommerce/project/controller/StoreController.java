package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.request.StoreAndProductRequest;
import com.ecommerce.project.request.StoreRequest;
import com.ecommerce.project.response.StoreAndProductResponse;
import com.ecommerce.project.response.StoreResponse;
import com.ecommerce.project.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeservice;

	@PostMapping("/add")
	public StoreResponse addStore(@RequestBody StoreRequest req) {
		return storeservice.addStore(req);
	}

	@PostMapping("/addstoreandproduct")
	public StoreAndProductResponse addstoreandproduct(@RequestBody StoreAndProductRequest sp) {

		return storeservice.addstoreandprocut(sp);
	}

	@GetMapping
	public List<StoreResponse> allStores(){
		
		return storeservice.findallstores();
		
	}
}
