package com.ufpb.geekspace.dto;

public class ShoppingCartDTO {
	private double totalValue;

	public ShoppingCartDTO() {
	}

	public ShoppingCartDTO(double totalValue) {
		super();
		this.totalValue = totalValue;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

}
