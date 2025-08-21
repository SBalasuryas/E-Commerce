package com.ecommerce.project.response;

import java.util.Date;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.ecommerce.project.entity.AddressEntity;
import com.ecommerce.project.entity.CustomerEntity;
import com.ecommerce.project.entity.ProductEntity;

public class OrderResponse {

	
	private Integer id;
	private Date orderdate;
	private CustomerEntity customer;
	private ProductEntity product;
	private AddressEntity address;
	private float totalprice;
	
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity addressEntity) {
		this.address = addressEntity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
}
