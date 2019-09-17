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
import com.ufpb.geekspace.model.Client;
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
	public List<Client> retrievAllClients(){
		return clientService.retrievAllClients();
	}
	
	@GetMapping(value = "/{clientId}")
	public Client retrieveOneClient(@PathVariable long clientId) {
		return clientService.retrieveOneClient(clientId);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<?> createClient(@RequestBody Client cliente) {
		return clientService.createClient(cliente);
	}
	
	@PutMapping
	public void editClient(@RequestBody Client client) {
		clientService.editClient(client);
	}
	
	@DeleteMapping(value = "/{clientId}")
	public void deleteClient(@PathVariable long clientId) {
		clientService.deleteClient(clientId);
	}
	
	@GetMapping(value = "/{clientId}/shopping-cart")
	public ShoppingCart getShoppingCart(@PathVariable long clientId){
		return shoppingCartService.retrieveShoppingCart(clientId);
	}
	
	@PutMapping(value = "{clientId}/shopping-cart/edit")
	public void editShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		shoppingCartService.editShoppingCart(shoppingCart);
	}
	
	@PostMapping(value = "/{clientId}/create-cart")
	public void createShoppingCart(@RequestBody ShoppingCart shoppingCart, @PathVariable long clientId) {
		shoppingCartService.createShoppingCart(shoppingCart, clientId);
		
	}
	
	@DeleteMapping(value = "/{clientId}/remove-item-from-cart/{itemId}")
	public void removeFromCart(@RequestBody ItemDTO item, @PathVariable long clientId, @PathVariable long itemId) {
		shoppingCartService.removeFromCart(clientId, itemId);
	}
}
