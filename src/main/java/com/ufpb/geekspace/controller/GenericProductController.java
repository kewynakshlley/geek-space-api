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

import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.service.GenericProductService;

@RestController
@RequestMapping(value = "generic-product")
public class GenericProductController {

	@Autowired
	private GenericProductService genericProductService;

	@GetMapping
	public List<GenericProduct> retrievAllProduct() {
		return genericProductService.retrievAllProduct();
	}

	@GetMapping(value = "/{productId}")
	public GenericProduct retrieveOneProduct(@PathVariable long productId) {
		return genericProductService.retrieveOneProduct(productId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createProduct(@RequestBody GenericProduct product) {
		return genericProductService.createProduct(product);
	}

	@PutMapping
	public void editProduct(@RequestBody GenericProduct product) {
		genericProductService.editProduct(product);
	}

	@DeleteMapping(value = "/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		genericProductService.deleteProduct(productId);
		;
	}
}
