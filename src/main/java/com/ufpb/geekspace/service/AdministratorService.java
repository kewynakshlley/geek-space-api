package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataAlreadyExistsException;
import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Administrator;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.util.UserUtil;

@Service
public class AdministratorService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Administrator> retrieveAdministrators() {
		return null;
	}

	public Administrator retrieveAdministrator(long administratorId) {
		Administrator aux = new Administrator();
		Client c = clientRepository.getOne(administratorId);
		aux.setEmail(c.getEmail());
		aux.setId(c.getId());
		aux.setPassword(c.getPassword());
		return aux;
	}

	public ResponseEntity<?> createAdministrator(Administrator administrator) throws Exception {
		
		Client c = clientRepository.findByEmail(administrator.getEmail());
		if(c != null)
			throw new DataAlreadyExistsException(UserUtil.USER_ALREADY_EXISTS);
		c = new Client();
		c.setEmail(administrator.getEmail());
		c.setPassword(administrator.getPassword());
		c.setRole(administrator.getRoles());
		clientRepository.save(c);
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}


	public void editAdministrator(Administrator administrator) throws DataNotFoundException {
		if(clientRepository.getOne(administrator.getId()) == null)
			throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		Client c = new Client();
		c.setId(administrator.getId());
		c.setEmail(administrator.getEmail());
		c.setPassword(administrator.getPassword());
		c.setRole(administrator.getRoles());
		clientRepository.save(c);
	}

	public void deleteAdministrator(long administratorId) throws DataNotFoundException {
		if(clientRepository.getOne(administratorId) == null)
			throw new DataNotFoundException(UserUtil.USER_NOT_FOUND);
		clientRepository.deleteById(administratorId);
		
	}

}
