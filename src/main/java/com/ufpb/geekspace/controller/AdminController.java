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

import com.ufpb.geekspace.model.Admin;
import com.ufpb.geekspace.service.AdminService;

@RestController
@RequestMapping(value = "admins")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/new")
	public ResponseEntity<?> createAdmin(@RequestBody Admin admin){
		return adminService.createAdmin(admin);
	}
	
	@GetMapping
	public List<Admin> getAllAdmins(){
		return adminService.retrievAllAdmins();
	}
	
	@GetMapping(value = "/{adminId}")
	public Admin getOneAdmin(@PathVariable long adminId) {
		return adminService.retrieveOneAdmin(adminId);
	}
	
	@PutMapping
	public void editAdmin(@RequestBody Admin admin) {
		adminService.editAdmin(admin);
	}
	
	@DeleteMapping(value = "/{adminId}")
	public void deleteAdmin(@PathVariable long adminId) {
		adminService.removeAdmin(adminId);
	}
	
	
	
}
