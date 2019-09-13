package com.ufpb.geekspace.dto;

public class ProductDTO {
	
	private long productId;
	
	public ProductDTO() {}

	public ProductDTO(long productId) {
		super();
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	
}
