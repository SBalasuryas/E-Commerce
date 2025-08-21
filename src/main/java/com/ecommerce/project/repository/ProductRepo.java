package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity , Integer> {

}
