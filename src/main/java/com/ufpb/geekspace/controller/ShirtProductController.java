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

import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.service.ShirtProductService;

@RestController
@RequestMapping(value = "shirt-product")
public class ShirtProductController {

	@Autowired
	private ShirtProductService shirtProductService;

	@GetMapping
	public List<ShirtProduct> retrievAllShirts() {
		return shirtProductService.retrievAllShirts();
	}

	@GetMapping(value = "/{shirtId}")
	public ShirtProduct retrieveOneShirtProduct(@PathVariable long shirtId) {
		return shirtProductService.retrieveOneShirtProduct(shirtId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createShirtProduct(@RequestBody ShirtProduct shirt) {
		return shirtProductService.createShirtProduct(shirt);
	}

	@PutMapping
	public void editShirtProduct(@RequestBody ShirtProduct shirt) {
		shirtProductService.editShirtProduct(shirt);
	}

	@DeleteMapping(value = "/{shirtId}")
	public void deleteShirtProduct(@PathVariable long shirtId) {
		shirtProductService.deleteShirtCamisa(shirtId);

	}

}
