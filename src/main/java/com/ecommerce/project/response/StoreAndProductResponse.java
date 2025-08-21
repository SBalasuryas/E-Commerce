package com.ecommerce.project.response;

import org.springframework.beans.factory.annotation.Autowired;

public class StoreAndProductResponse {

	@Autowired
	private StoreResponse storeresponse;
	
	@Autowired
	private ProductResponse productresponse;

	public StoreResponse getStoreresponse() {
		return storeresponse;
	}

	public void setStoreresponse(StoreResponse storeresponse) {
		this.storeresponse = storeresponse;
	}

	public ProductResponse getProductresponse() {
		return productresponse;
	}

	public void setProductresponse(ProductResponse productresponse) {
		this.productresponse = productresponse;
	}



	
}
