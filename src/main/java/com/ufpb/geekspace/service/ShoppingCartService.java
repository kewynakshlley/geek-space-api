package com.ufpb.geekspace.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.model.Item;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.model.ShoppingCart;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.repository.GenericProductRepository;
import com.ufpb.geekspace.repository.ItemRepository;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ShirtProductRepository shirtProductRepository;
	@Autowired
	private GenericProductRepository genericProductRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public ShoppingCart retrieveShoppingCart(long clientId) {
		ShoppingCart sc = shoppingCartRepository.findByClientId(clientId);
		return sc;
	}
	
	public void createShoppingCart(ShoppingCart shoppingCart, long clientId){
		Client caux = clientRepository.getOne(clientId);
		Set<Item> iaux = shoppingCart.getItems();
		
		for(Item i: iaux) {
			Product gp = genericProductRepository.getOne(i.getProduct().getId());
			Product sp = shirtProductRepository.getOne(i.getProduct().getId());
			if(gp != null) {
				i.setProduct(gp);
				continue;
			}if(sp != null) {
				i.setProduct(sp);
			}i.setShoppingCart(shoppingCart);
		}
		shoppingCart.setItems(iaux);
		shoppingCart.setClient(caux);
		caux.setShoppingCart(shoppingCart);
		shoppingCartRepository.save(shoppingCart);
	}

	public void editShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);

	}

	public void removeFromCart(long clientId, long itemId) {
		ShoppingCart sc = shoppingCartRepository.findByClientId(clientId);
		for(Item i: sc.getItems()) {
			if(i.getId() == itemId) {
				sc.getItems().remove(i);
			}
		}
		shoppingCartRepository.save(sc);

	}


}
