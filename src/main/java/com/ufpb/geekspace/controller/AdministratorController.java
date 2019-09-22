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

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Administrator;
import com.ufpb.geekspace.service.AdministratorService;

@RestController
@RequestMapping(value = "administrators")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;

	@GetMapping
	public List<Administrator> retrieveAdministrators() {
		return administratorService.retrieveAdministrators();
	}

	@GetMapping(value = "/{administratorId}")
	public Administrator retrieveAdministrator(@PathVariable long administratorId) {
		return administratorService.retrieveAdministrator(administratorId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createAdministrator(@RequestBody Administrator administrator) throws Exception {
		return administratorService.createAdministrator(administrator);
	}

	@PutMapping
	public void editAdministrator(@RequestBody Administrator administrator) throws DataNotFoundException {
		administratorService.editAdministrator(administrator);
	}

	@DeleteMapping(value = "/{administratorId}")
	public void deleteAdministrator(@PathVariable long administratorId) throws DataNotFoundException {
		administratorService.deleteAdministrator(administratorId);
	}

}
