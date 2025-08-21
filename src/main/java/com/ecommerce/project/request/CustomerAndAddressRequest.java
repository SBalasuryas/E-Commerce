package com.ecommerce.project.request;

public class CustomerAndAddressRequest {

	private String name;
	private String email;
	
	private AddressRequest addressrequest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressRequest getAddressrequest() {
		return addressrequest;
	}

	public void setAddressrequest(AddressRequest addressrequest) {
		this.addressrequest = addressrequest;
	}
	
	
	
}
