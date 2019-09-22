package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataAlreadyExistsException;
import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.util.UserUtil;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> retrievAllClients() {
		return clientRepository.findAll();
	}

	public Client retrieveOneClient(long clienteId) throws DataNotFoundException {
		Client aux = clientRepository.getOne(clienteId);
		if (aux == null)
			throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		return clientRepository.getOne(clienteId);
	}

	public ResponseEntity<?> createClient(Client client) throws DataAlreadyExistsException {

		Client createdClient = clientRepository.findByEmail(client.getEmail());
		if (createdClient != null)
			throw new DataAlreadyExistsException(UserUtil.USER_ALREADY_EXISTS);
		createdClient = clientRepository.save(client);
		return new ResponseEntity<Client>(createdClient, HttpStatus.OK);

	}

	public ResponseEntity<?> editClient(Client client) throws DataNotFoundException {
		Client createdClient = clientRepository.getOne(client.getId());
		if (createdClient == null)
			throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		createdClient = clientRepository.save(client);
		return new ResponseEntity<Client>(createdClient, HttpStatus.OK);

	}

	public void deleteClient(long clientId) throws DataNotFoundException {
		Client createdClient = clientRepository.getOne(clientId);
		if (createdClient == null)
			throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		clientRepository.deleteById(clientId);

	}

}
