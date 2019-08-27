package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.Admin;
import com.ufpb.geekspace.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin> retrievAllAdmins(){
		return adminRepository.findAll();
	}
	
	public Admin retrieveOneAdmin(long adminId) {
		return adminRepository.getOne(adminId);
	}
	
	public ResponseEntity<?> createAdmin(Admin admin) {
		Admin createdAdmin = adminRepository.save(admin);
		return new ResponseEntity<Admin>(createdAdmin, HttpStatus.OK);
	}
	
	public ResponseEntity<?> editAdmin(Admin admin) {
		Admin createdAdmin = adminRepository.save(admin);
		return new ResponseEntity<Admin>(createdAdmin, HttpStatus.OK);
	}
	
	public void removeAdmin(long adminId) {
		adminRepository.deleteById(adminId);
	}
	
	
}
