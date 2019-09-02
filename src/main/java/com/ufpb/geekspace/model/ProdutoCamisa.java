package com.ufpb.geekspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProdutoCamisa extends ProdutoGenerico {
	
	@Column(name = "COR_CAMISA")
	private String color;
	
	@Column(name =" GENERO_CAMISA")
	private String genre;
	
	public ProdutoCamisa () {
		
	}

	public ProdutoCamisa(String color, String genre) {
		super();
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
