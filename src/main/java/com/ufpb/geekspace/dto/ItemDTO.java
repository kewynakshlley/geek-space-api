package com.ufpb.geekspace.dto;

public class ItemDTO {
	private double totalValue;

	public ItemDTO() {
	}

	public ItemDTO(double totalValue) {
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
