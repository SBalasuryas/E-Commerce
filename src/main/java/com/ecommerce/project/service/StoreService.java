package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entity.ProductEntity;
import com.ecommerce.project.entity.StoreEntity;
import com.ecommerce.project.repository.ProductRepo;
import com.ecommerce.project.repository.StoreRepo;
import com.ecommerce.project.request.StoreAndProductRequest;
import com.ecommerce.project.request.StoreRequest;
import com.ecommerce.project.response.ProductResponse;
import com.ecommerce.project.response.StoreAndProductResponse;
import com.ecommerce.project.response.StoreResponse;

@Service
public class StoreService {

	@Autowired
	private StoreRepo storerepo;

	@Autowired
	private ProductRepo productrepo;
	
	public StoreResponse addStore(StoreRequest req) {
		StoreEntity entity = new StoreEntity();
		entity.setName(req.getName());
		entity.setLocation(req.getLocation());
		storerepo.save(entity);

		StoreResponse res = new StoreResponse();
		res.setId(entity.getId());
		res.setName(entity.getName());
		res.setLocation(entity.getLocation());

		return res;
	}
	
	
	public StoreAndProductResponse addstoreandprocut(StoreAndProductRequest sp) {

		StoreEntity storeentity = new StoreEntity();

		storeentity.setName(sp.getName());
		storeentity.setLocation(sp.getLocation());
		storerepo.save(storeentity);

		ProductEntity productentity = new ProductEntity();
		productentity.setName(sp.getProductdetails().getName());
		productentity.setPrice(sp.getProductdetails().getPrice());
		productentity.setStore(storeentity);
		productrepo.save(productentity);

		StoreAndProductResponse res = new StoreAndProductResponse();
		StoreResponse sresponse = new StoreResponse();
		sresponse.setId(storeentity.getId());
		sresponse.setLocation(storeentity.getLocation());
		sresponse.setName(storeentity.getName());

		ProductResponse presponse = new ProductResponse();
		presponse.setId(productentity.getId());
		presponse.setName(productentity.getName());
		presponse.setPrice(presponse.getPrice());

		res.setStoreresponse(sresponse);
		res.setProductresponse(presponse);
		return res;
	}


	public List<StoreResponse> findallstores() {
		
		List<StoreEntity> entity = storerepo.findAll();
		List<StoreResponse> response = new ArrayList<>();
		
		for(StoreEntity store : entity) {
			StoreResponse result = new StoreResponse();
			
			result.setId(store.getId());
			result.setName(store.getName());
			result.setLocation(store.getLocation());
			response.add(result);
		}
		
		
		return response;
	}
}




































