package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entity.AddressEntity;
import com.ecommerce.project.entity.CustomerEntity;
import com.ecommerce.project.repository.AddressRepo;
import com.ecommerce.project.repository.CustomerRepo;
import com.ecommerce.project.request.CustomerAndAddressRequest;
import com.ecommerce.project.request.CustomerRequest;
import com.ecommerce.project.response.AddressResponse;
import com.ecommerce.project.response.CustomerAndAddressResponse;
import com.ecommerce.project.response.CustomerResponse;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerrepo;
	
	@Autowired
	private AddressRepo addressrepo;

	
	public CustomerResponse addCustomer(CustomerRequest req) {
		CustomerEntity entity = new CustomerEntity();
		entity.setName(req.getName());
		entity.setEmail(req.getEmail());
		customerrepo.save(entity);

		CustomerResponse response = new CustomerResponse();
		response.setId(entity.getId());
		response.setName(entity.getName());
		response.setEmail(entity.getEmail());
		return response;
	}
	
	
	public CustomerAndAddressResponse addCustoemrandService(CustomerAndAddressRequest ca) {

		CustomerEntity customerentity = new CustomerEntity();

		customerentity.setName(ca.getName());
		customerentity.setEmail(ca.getEmail());
		customerrepo.save(customerentity);

		AddressEntity addressentity = new AddressEntity();

		addressentity.setCustomerId(customerentity);
		addressentity.setStreet(ca.getAddressrequest().getStreet());
		addressentity.setCity(ca.getAddressrequest().getCity());
		addressentity.setState(ca.getAddressrequest().getState());
		addressentity.setZipcode(ca.getAddressrequest().getZipcode());
		addressrepo.save(addressentity);

		CustomerAndAddressResponse res = new CustomerAndAddressResponse();

		CustomerResponse cres = new CustomerResponse();
		cres.setId(customerentity.getId());
		cres.setName(customerentity.getName());
		cres.setEmail(customerentity.getEmail());

		AddressResponse ares = new AddressResponse();
		ares.setId(addressentity.getId());
		ares.setStreet(addressentity.getStreet());
		ares.setCity(addressentity.getCity());
		ares.setState(addressentity.getState());
		ares.setZipcode(addressentity.getZipcode());

		res.setCustomerresponse(cres);
		res.setAddressresponse(ares);

		return res;
	}
	
	
	
	public List<CustomerResponse> findAllCustomer(){

		List<CustomerEntity> customer = customerrepo.findAll();
		
		List<CustomerResponse> response  =new ArrayList<>();
		for(CustomerEntity person: customer) {
			CustomerResponse res = new CustomerResponse();
			res.setId(person.getId());
			res.setName(person.getName());
			res.setEmail(person.getEmail());
			response.add(res);
		}
		
		return response;
	}


}
