package com.ecommerce.project.response;

public class CustomerAndAddressResponse {

	
	private CustomerResponse customerresponse;
	
	private AddressResponse addressresponse;

	public CustomerResponse getCustomerresponse() {
		return customerresponse;
	}

	public void setCustomerresponse(CustomerResponse customerresponse) {
		this.customerresponse = customerresponse;
	}

	public AddressResponse getAddressresponse() {
		return addressresponse;
	}

	public void setAddressresponse(AddressResponse addressresponse) {
		this.addressresponse = addressresponse;
	}
	
	
}
