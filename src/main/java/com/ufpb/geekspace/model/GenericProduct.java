package com.ufpb.geekspace.model;


import java.util.Set;

import javax.persistence.Entity;

@Entity
public class GenericProduct extends Product{
	
	public GenericProduct() {}

	public GenericProduct(long id, String name, int quantity, double price, String specification, String description,
			Set<Client> client) {
		super(id, name, quantity, price, specification, description, client);
	}
	
	

}
