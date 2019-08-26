package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ufpb.geekspace.model.Cliente;
import com.ufpb.geekspace.repository.ClientRepository;

@Service
public class ClienteService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Cliente> retrievAllClientes() {
		return clientRepository.findAll();
	}

	public Cliente retrieveOneClient(long clienteId) {
		return clientRepository.getOne(clienteId);
	}

	public ResponseEntity<?> createCliente(Cliente cliente) {
		Cliente createdClient = clientRepository.save(cliente);
		return new ResponseEntity<Cliente>(createdClient, HttpStatus.OK);
		
	}

	public ResponseEntity<?> editMember(Cliente client) {
		Cliente createdClient = clientRepository.save(client);
		return new ResponseEntity<Cliente>(createdClient, HttpStatus.OK);
		
	}

	public void deleteClient(long clientId) {
		clientRepository.deleteById(clientId);
		
	}

}
