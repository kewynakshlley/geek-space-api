package com.ufpb.geekspace.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Client {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@ManyToMany
	@JoinTable(
	  name = "shopping_cart", 
	  joinColumns = @JoinColumn(name = "client_id"), 
	  inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> shoppingCart;

	public Client() {
	}

	public Client(long id, String firstName, String lastName, String password, String email,
			Set<Product> shoppingCart) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.shoppingCart = shoppingCart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Product> getCart() {
		return shoppingCart;
	}

	public void setCart(Set<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
