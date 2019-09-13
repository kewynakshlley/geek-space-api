package com.ufpb.geekspace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable = false)
	private Client client;
	
	
//	private ShoppingCart items;
	
	@Column(name = "PAYMENT")
	private String payment;
	
	@Column(name = "CEP")
	private String cep;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "NUMBER")
	private String number;
	
	@Column(name = "NEIGHBORHOOD")
	private String neighborhood;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "COMPLEMENT")
	private String complement;
	
	public Sale() {}
	
	public Sale(int id, Client client, ShoppingCart items, String payment, String cep, String street, String number,
			String neighborhood, String city, String state, String complement) {
		super();
		this.id = id;
		this.client = client;
//		this.items = items;
		this.payment = payment;
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.complement = complement;
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

//	public ShoppingCart getItems() {
//		return items;
//	}

//	public void setItems(ShoppingCart items) {
//		this.items = items;
//	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	

}