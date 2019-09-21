package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> retrievAllClients() {
		return clientRepository.findAll();
	}

	public Client retrieveOneClient(long clienteId) {
		return clientRepository.getOne(clienteId);
	}

	public ResponseEntity<?> createClient(Client cliente) {
		Client createdClient = clientRepository.save(cliente);
		return new ResponseEntity<Client>(createdClient, HttpStatus.OK);

	}

	public ResponseEntity<?> editClient(Client client) {
		Client createdClient = clientRepository.save(client);
		return new ResponseEntity<Client>(createdClient, HttpStatus.OK);

	}

	public void deleteClient(long clientId) {
		clientRepository.deleteById(clientId);

	}

	
}
