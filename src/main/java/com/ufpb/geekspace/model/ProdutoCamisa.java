package com.ufpb.geekspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProdutoCamisa extends ProdutoGenerico {
	
	@Column(name = "COR_CAMISA")
	private String cor;
	
	@Column(name =" GENERO_CAMISA")
	private String genero;
	
	public ProdutoCamisa () {
		
	}

	public ProdutoCamisa(String cor, String genero) {
		super();
		this.cor = cor;
		this.genero = genero;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
}
