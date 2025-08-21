package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.request.CustomerAndAddressRequest;
import com.ecommerce.project.request.CustomerRequest;
import com.ecommerce.project.response.CustomerAndAddressResponse;
import com.ecommerce.project.response.CustomerResponse;
import com.ecommerce.project.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/add")
	public CustomerResponse addCustomer(@RequestBody CustomerRequest request) {
		return customerService.addCustomer(request);
	}

	@PostMapping()
	public CustomerAndAddressResponse addCustomerandaddressResponse(@RequestBody CustomerAndAddressRequest request) {
		return customerService.addCustoemrandService(request);
	}

	@GetMapping("/all")
	public List<CustomerResponse> findAllCustomer(){	
		return customerService.findAllCustomer();
	}

	
	
	

}
