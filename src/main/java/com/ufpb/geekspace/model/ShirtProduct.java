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

	@Column(name = "SIZE")
	private String size;

	public ShirtProduct() {

	}

	public ShirtProduct(long id, String name, String category, int quantity, double price, String specification,
			String description, List<Item> items, String image, String color, String genre, String size) {
		super(id, name, category, quantity, price, specification, description, items, image);
		this.color = color;
		this.genre = genre;
		this.size = size;

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
