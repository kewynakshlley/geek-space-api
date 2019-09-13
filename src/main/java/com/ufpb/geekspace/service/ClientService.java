package com.ufpb.geekspace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.dto.ProductDTO;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.repository.GenericProductRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private GenericProductRepository productRepository;

	@Autowired
	private ShirtProductRepository shirtRepository;

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

	public List<Product> retrieveShoppingCart(long clientId) {
		List<Product> aux = new ArrayList<>();
		List<GenericProduct> sc =  productRepository.findShoppingCart(clientId);
		List<ShirtProduct> sp =  shirtRepository.findShoppingCart(clientId);
		aux.addAll(sc);
		aux.addAll(sp);
		return aux;
	}

	public void addToCart(List<ProductDTO> items, long clientId) {
		Client caux = clientRepository.getOne(clientId);
		for (ProductDTO pdto : items) {
			Product pg = productRepository.getOne(pdto.getProductId());
			ShirtProduct pc = shirtRepository.getOne(pdto.getProductId());
			if (pg != null) {
				caux.getCart().add(pg);
				continue;
			}
			if (pc != null)
				caux.getCart().add(pc);
		}
		clientRepository.save(caux);

	}

	public void removeFromCart(long clientId, ProductDTO product) {
		Client caux = clientRepository.getOne(clientId);

		Product pg = productRepository.getOne(product.getProductId());
		if (pg != null)
			caux.getCart().remove(pg);

		ShirtProduct pc = shirtRepository.getOne(product.getProductId());
		if (pc != null)
			caux.getCart().remove(pc);
		clientRepository.save(caux);

	}

}
