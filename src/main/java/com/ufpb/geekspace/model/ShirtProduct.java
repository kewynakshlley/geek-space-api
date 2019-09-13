package com.ufpb.geekspace.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ShirtProduct extends Product {

	@Column(name = "COR_CAMISA")
	private String color;

	@Column(name = " GENERO_CAMISA")
	private String genre;

	public ShirtProduct() {

	}

	public ShirtProduct(long id, String name, int quantity, double price, String specification, String description,
			Set<Client> client, String color, String genre) {
		super(id, name, quantity, price, specification, description, client);
		this.color = color;
		this.genre = genre;
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
