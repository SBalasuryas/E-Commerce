package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.StoreEntity;

public interface StoreRepo extends JpaRepository<StoreEntity, Integer>{

	
}
