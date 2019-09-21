package com.ufpb.geekspace.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.repository.ClientRepository;
import com.ufpb.geekspace.service.ClientService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

	@InjectMocks
	private ClientService service;
	
	@Mock
	private ClientRepository repository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getClientsTest() {
		when(repository.findAll()).
		thenReturn(new ArrayList<Client>(List.of(
				new Client(65, "kewynakshlley@gmail.com", "123", null, null, null, null),
				new Client(100, "fulano@gmail.com", "123", null, null, null, null))));
		List<Client> laux = service.retrievAllClients();
		verify(repository).findAll();
		assertEquals(2, laux.size());
	}
	
	@Test
	public void getClientTest() {
		Client client = new Client();
		client.setId(1l);
		when(repository.getOne(1l)).thenReturn(client);
		Client clientAux = service.retrieveOneClient(1L);
		verify(repository).getOne(1l);
		assertEquals(1l, clientAux.getId());
	}
	
	@Test
	public void saveClientTest() {
		Client client = new Client(1, "kewynakshlley@gmail.com", "123", null, null, null, null);
		
		when(repository.save(client)).thenReturn(client);
		ResponseEntity<?> rax = service.createClient(client);
		verify(repository).save(client);
		assertTrue("should be true", rax != null);
	}
	
	@Test
	public void deleteClientTest() {
		Client client = new Client(2, "kewynakshlley@gmail.com", "123", null, null, null, null);
		service.deleteClient(client.getId());
		verify(repository, times(1)).deleteById(client.getId());
	}

}
