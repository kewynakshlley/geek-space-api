package com.ufpb.geekspace.model;


import java.util.List;


import javax.persistence.Entity;

@Entity
public class GenericProduct extends Product{
	
	public GenericProduct() {}

	public GenericProduct(long id, String name, String category, int quantity, double price, String specification,
			String description, List<Item> items, String image, List<Client> clients) {
		super(id, name, category, quantity, price, specification, description, items, image, clients);

	}

	
	
	

}
