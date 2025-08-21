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

import com.ecommerce.project.request.AddressRequest;
import com.ecommerce.project.response.AddressResponse;
import com.ecommerce.project.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	
	@PostMapping("/add")
	public AddressResponse addAddress(@RequestBody AddressRequest request) {
		return addressService.addAddress(request);
	}
	
	@PutMapping("/update/{id}")
	public String updateAddress(@PathVariable int id, @RequestBody AddressRequest address) {
		return addressService.updateAddress(id,address);
		
	}
	
	@GetMapping
	public List<AddressResponse> findAllAddress(){
		return addressService.findAllAddress();
	}

}
