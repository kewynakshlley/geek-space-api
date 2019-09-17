package com.ufpb.geekspace.dto;

public class ItemDTO {

	private long productId;
	private int quantity;
	private double totalValue;

	public ItemDTO() {
	}

	public ItemDTO(long productId, int quantity, double totalValue) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.totalValue = totalValue;

	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}



}
