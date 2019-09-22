package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataAlreadyExistsException;
import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.repository.GenericProductRepository;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.util.ProductUtil;
import com.ufpb.geekspace.util.UserUtil;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ShirtProductRepository shirtProductRepository;
	@Autowired
	private GenericProductRepository genericProductRepository;

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
		clientRepository.delete(createdClient);

	}

	public void addToFavorites(long clientId, long productId) throws DataNotFoundException {
		Client caux = clientRepository.getOne(clientId);
		Product paux = null;
		
		ShirtProduct saux = shirtProductRepository.getOne(productId);
		
		GenericProduct gaux = genericProductRepository.getOne(productId);
		if(saux != null)
			paux = saux;
		else
			paux = gaux;
		
		if(caux == null) throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		if(paux == null) throw new DataNotFoundException(ProductUtil.PRODUCT_NOT_FOUND);
		
		caux.getFavorites().add(paux);
		paux.getClients().add(caux);
		clientRepository.save(caux);
		
		
		
	}

	public List<Product> getFavorites(long clientId) {
		Client caux = clientRepository.getOne(clientId);
		return caux.getFavorites();
	}

	public void deleteFavorite(long clientId, long productId) {
		Client caux = clientRepository.getOne(clientId);
		Product aux = null;
		for(Product p: caux.getFavorites()) {
			if(p.getId() == productId)
				aux = p;
		}
		caux.getFavorites().remove(aux);
		clientRepository.save(caux);
		
	}

}
