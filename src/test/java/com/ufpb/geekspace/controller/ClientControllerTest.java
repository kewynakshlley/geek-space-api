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

import com.ufpb.geekspace.model.Administrator;
import com.ufpb.geekspace.repository.AdministratorRepository;
import com.ufpb.geekspace.service.AdministratorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministratorControllerTest {

	@InjectMocks
	private AdministratorService service;
	
	@Mock
	private AdministratorRepository repository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAdministratorsTest() {
		when(repository.findAll()).
		thenReturn(new ArrayList<Administrator>(List.of(
				new Administrator(65, "kewynakshlley@gmail.com", "123"),
				new Administrator(100, "fulano@gmail.com", "123"))));
		List<Administrator> laux = service.retrievAllAdmins();
		verify(repository).findAll();
		assertEquals(2, laux.size());
	}
	
	@Test
	public void getAdministratorTest() {
		Administrator adm = new Administrator();
		adm.setId(1l);
		when(repository.getOne(1l)).thenReturn(adm);
		Administrator admAux = service.retrieveOneAdmin(1L);
		verify(repository).getOne(1l);
		assertEquals(1l, admAux.getId());
	}
	
	@Test
	public void saveAdministratorTest() {
		Administrator adm = new Administrator(1, "kewynakshlley@gmail.com", "123");
		
		when(repository.save(adm)).thenReturn(adm);
		ResponseEntity<?> rax = service.createAdmin(adm);
		verify(repository).save(adm);
		assertTrue("should be true", rax != null);
	}
	
	@Test
	public void deleteAdministratorTest() {
		Administrator adm = new Administrator(2, "kewynakshlley@gmail.com", "123");
		service.removeAdmin(adm.getId());
		verify(repository, times(1)).deleteById(adm.getId());
	}

}
