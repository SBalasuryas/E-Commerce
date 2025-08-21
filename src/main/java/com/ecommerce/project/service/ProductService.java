package com.ecommerce.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entity.ProductEntity;
import com.ecommerce.project.repository.ProductRepo;
import com.ecommerce.project.request.ProductRequest;
import com.ecommerce.project.response.ProductResponse;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;

	public ProductResponse addProduct(ProductRequest req) {
		ProductEntity entity = new ProductEntity();
		entity.setName(req.getName());
		entity.setPrice(req.getPrice());
		productrepo.save(entity);

		ProductResponse res = new ProductResponse();
		res.setId(entity.getId());
		res.setName(entity.getName());
		res.setPrice(entity.getPrice());

		return res;
	}

	public String updateProduct(int id, ProductRequest req) {

		Optional<ProductEntity> product = productrepo.findById(id);

		if (product.isPresent()) {
			ProductEntity pro = product.get();
			pro.setName(req.getName());
			pro.setPrice(req.getPrice());
			productrepo.save(pro);

			return "Product updated successfully";
		} else {
			return "Product Not found!!!";
		}
	}

	public List<ProductEntity> findAllProduct() {

		return productrepo.findAll();
	}

}
