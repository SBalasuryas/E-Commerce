package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {

//	AddressEntity findByCustomer(Integer id);
	
}
