package com.ecommerce.project.request;

import java.util.Date;
import java.util.List;

public class OrderRequest {

	
	private Date orderdate;
	private Integer customerId;
	private Integer addressId;
	private List<OrderAndProductRequest> orderAndProduct;

	
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public List<OrderAndProductRequest> getOrderandproduct() {
		return orderAndProduct;
	}
	public void setOrderandproduct(List<OrderAndProductRequest> orderandproduct) {
		this.orderAndProduct = orderandproduct;
	}
	
	
//	public List<Integer> getProductId() {
//		return productId;
//	}
//	public void setProductId(List<Integer> productId) {
//		this.productId = productId;
//	}
//	public Integer getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//	
}
