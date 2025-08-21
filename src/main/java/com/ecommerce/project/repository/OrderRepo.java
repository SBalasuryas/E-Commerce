package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{

}






