package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.entity.CustomerEntity;


public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>  {

}
