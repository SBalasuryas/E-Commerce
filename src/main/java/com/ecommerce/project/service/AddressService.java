package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entity.AddressEntity;
import com.ecommerce.project.repository.AddressRepo;
import com.ecommerce.project.request.AddressRequest;
import com.ecommerce.project.response.AddressResponse;

@Service
public class AddressService {

	
	@Autowired
	private AddressRepo addressrepo;

	
	public AddressResponse addAddress(AddressRequest req) {
		AddressEntity entity = new AddressEntity();
		entity.setStreet(req.getStreet());
		entity.setCity(req.getCity());
		entity.setState(req.getState());
		entity.setZipcode(req.getZipcode());
		addressrepo.save(entity);

		AddressResponse res = new AddressResponse();
		res.setId(entity.getId());
		res.setStreet(entity.getStreet());
		res.setCity(entity.getCity());
		res.setState(entity.getState());
		res.setZipcode(entity.getZipcode());

		return res;
	}
	
	
	
	public String updateAddress(int id, AddressRequest address) {

		Optional<AddressEntity> addressid = addressrepo.findById(id);

		if (addressid.isPresent()) {
			AddressEntity entity = addressid.get();
			entity.setStreet(address.getStreet());
			entity.setCity(address.getCity());
			entity.setState(address.getState());
			entity.setZipcode(address.getZipcode());
			addressrepo.save(entity);
			return "Customer not found";

		}
		else {
//			System.out.print("Customer not found");
			return "Customer not found";
		}
	}

	public List<AddressResponse> findAllAddress() {
		
		List<AddressEntity> address = addressrepo.findAll();
		List<AddressResponse> response = new ArrayList<>();
		for(AddressEntity oneaddress : address) {
			AddressResponse entity = new AddressResponse();
			entity.setCity(oneaddress.getCity());
			entity.setState(oneaddress.getState());
			entity.setStreet(oneaddress.getStreet());
			entity.setId(oneaddress.getId());
			entity.setZipcode(oneaddress.getZipcode());
			response.add(entity);
			
		}
		return response;
	}
}





























