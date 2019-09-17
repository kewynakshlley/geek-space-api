package com.ufpb.geekspace.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_cart_id")
	private Set<Item> items = new HashSet<>();
	@OneToOne(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	@JsonIgnore
	private Sale sale;
	@Column(name = "SUB_TOTAL")
	private int subTotal;

	public ShoppingCart() {

	}

	public ShoppingCart(long id, Client client, Sale sale, int subTotal, Item... items) {
		super();
		this.id = id;
		this.client = client;
		this.items = Stream.of(items).collect(Collectors.toSet());
		this.items.forEach(x -> x.setShoppingCart(this));
		this.sale = sale;
		this.subTotal =  subTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
		/*this.items.clear();
		for(Item item: items) {
			item.setShoppingCart(this);
			this.items.add(item);
		}*/
		
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
}
