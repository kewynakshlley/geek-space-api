package com.ufpb.geekspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "TOTAL_VALUE")
	private double subtotal;
	@JsonIgnore
	@ManyToOne
	private ShoppingCart shoppingCart;

	public Item() {
	}

	public Item(long id, Product product, int quantity, double subtotal, ShoppingCart shoppingCart) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.shoppingCart = shoppingCart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
