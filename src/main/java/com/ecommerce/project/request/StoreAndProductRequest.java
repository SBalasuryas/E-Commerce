package com.ecommerce.project.request;

public class StoreAndProductRequest {
	
	private String name;
	private String location;
	
	private ProductRequest productdetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ProductRequest getProductdetails() {
		return productdetails;
	}

	public void setProductdetails(ProductRequest productdetails) {
		this.productdetails = productdetails;
	}
	

}
