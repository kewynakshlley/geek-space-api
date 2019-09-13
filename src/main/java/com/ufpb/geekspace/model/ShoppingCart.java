package com.ufpb.geekspace.model;

public class ShoppingCart {
	private long clientId;
	private long productId;
	
	public ShoppingCart () {
		
	}

	public ShoppingCart(long clientId, long productId) {
		super();
		this.clientId = clientId;
		this.productId = productId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	

}
