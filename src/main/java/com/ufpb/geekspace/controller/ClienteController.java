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

import com.ufpb.geekspace.model.Cliente;
import com.ufpb.geekspace.service.ClienteService;

@RestController
@RequestMapping(value = "clients")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> retrievAllClientes(){
		return clienteService.retrievAllClientes();
	}
	
	@GetMapping(value = "/{clientId}")
	public Cliente retrieveOneClient(@PathVariable long clienteId) {
		return clienteService.retrieveOneClient(clienteId);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<?> createClient(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}
	
	@PutMapping
	public void editClient(@RequestBody Cliente client) {
		clienteService.editMember(client);
	}
	
	@DeleteMapping(value = "/{clientId}")
	public void deleteClient(@PathVariable long clientId) {
		clienteService.deleteClient(clientId);
	}
}
