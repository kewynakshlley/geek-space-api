package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.Administrator;
import com.ufpb.geekspace.repository.AdministratorRepository;

@Service
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository adminRepository;
	
	public List<Administrator> retrievAllAdmins(){
		return adminRepository.findAll();
	}
	
	public Administrator retrieveOneAdmin(long adminId) {
		return adminRepository.getOne(adminId);
	}
	
	public ResponseEntity<?> createAdmin(Administrator admin) {
		Administrator createdAdmin = adminRepository.save(admin);
		return new ResponseEntity<Administrator>(createdAdmin, HttpStatus.OK);
	}
	
	public ResponseEntity<?> editAdmin(Administrator admin) {
		Administrator createdAdmin = adminRepository.save(admin);
		return new ResponseEntity<Administrator>(createdAdmin, HttpStatus.OK);
	}
	
	public void removeAdmin(long adminId) {
		adminRepository.deleteById(adminId);
	}
	
	
}
