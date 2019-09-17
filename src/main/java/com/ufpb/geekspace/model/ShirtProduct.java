package com.ufpb.geekspace.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ShirtProduct extends Product {

	@Column(name = "COLOR")
	private String color;

	@Column(name = " GENRE")
	private String genre;

	public ShirtProduct() {

	}

	public ShirtProduct(long id, String name, String category, int quantity, double price, String specification,
			String description, List<Item> items) {
		super(id, name, category, quantity, price, specification, description, items);

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
