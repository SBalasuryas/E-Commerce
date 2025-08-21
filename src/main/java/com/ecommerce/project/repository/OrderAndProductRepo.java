package com.ecommerce.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.OrderAndProductEntity;

public interface OrderAndProductRepo extends JpaRepository<OrderAndProductEntity, Integer> {

	
	List<OrderAndProductEntity> findByOrderId(Integer orderid);
}
