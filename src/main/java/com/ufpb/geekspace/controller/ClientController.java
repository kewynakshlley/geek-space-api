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

import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.model.ProdutoGenerico;
import com.ufpb.geekspace.service.ClientService;

@RestController
@RequestMapping(value = "clients")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
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
	public List<ProdutoGenerico> getShoppingCart(@PathVariable long clientId){
		return clientService.retrieveShoppingCart(clientId);
	}
}
