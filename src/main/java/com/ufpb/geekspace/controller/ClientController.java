package com.ufpb.geekspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.geekspace.dto.ItemDTO;
import com.ufpb.geekspace.exception.DataAlreadyExistsException;
import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.model.Item;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.model.ShoppingCart;
import com.ufpb.geekspace.service.ClientService;
import com.ufpb.geekspace.service.ShoppingCartService;

@RestController
@RequestMapping(value = "clients")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@GetMapping
	public List<Client> retrievAllClients() {
		return clientService.retrievAllClients();
	}

	@GetMapping(value = "/{clientId}")
	public Client retrieveOneClient(@PathVariable long clientId) throws DataNotFoundException {
		return clientService.retrieveOneClient(clientId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createClient(@RequestBody Client cliente) throws DataAlreadyExistsException {
		return clientService.createClient(cliente);
	}

	@PutMapping
	public void editClient(@RequestBody Client client) throws DataNotFoundException {
		clientService.editClient(client);
	}

	@DeleteMapping(value = "/{clientId}")
	public void deleteClient(@PathVariable long clientId) throws DataNotFoundException {
		clientService.deleteClient(clientId);
	}

	@GetMapping(value = "/{clientId}/shopping-cart")
	public ShoppingCart getShoppingCart(@PathVariable long clientId) throws DataNotFoundException {
		return shoppingCartService.retrieveShoppingCart(clientId);
	}

	@PutMapping(value = "{clientId}/shopping-cart/edit")
	public void editShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		shoppingCartService.editShoppingCart(shoppingCart);
	}

	@PostMapping(value = "/{clientId}/create-cart")
	public void createShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable long clientId)
			throws DataNotFoundException {
		shoppingCartService.createShoppingCart(shoppingCart, clientId);

	}
	
	@PostMapping(value = "/{clientId}/add-item")
	public void addItem(@RequestBody Item item, @PathVariable long clientId) {
		shoppingCartService.addItem(item, clientId);
	}

	@DeleteMapping(value = "/{clientId}/remove-item/{itemId}")
	public void removeItem(@PathVariable long clientId, @PathVariable long itemId) {
		shoppingCartService.removeItem(clientId, itemId);
	}
	
	@PostMapping(value = "{clientId}/add-to-favorites/{productId}")
	public void addToFavorites(@PathVariable long clientId, @PathVariable long productId) throws DataNotFoundException {
		clientService.addToFavorites(clientId, productId);
	}
	
	@GetMapping(value = "{clientId}/favorites")
	public List<Product> getFavorites(@PathVariable long clientId){
		return clientService.getFavorites(clientId);
	}
}
