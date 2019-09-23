package com.ufpb.geekspace.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.service.ProductService;

@RestController
@RequestMapping(value = "all-product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> retrievAllProduct() {
		return productService.retrievAllProduct();
	}

	@GetMapping(value = "/{productId}")
	public Product retrieveOneProduct(@PathVariable long productId) {
		return productService.retrieveOneProduct(productId);
	}

	@PostMapping(value = "/new")
	public ResponseEntity<?> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping
	public void editProduct(@RequestBody Product product) {
		productService.editProduct(product);
	}

	@DeleteMapping(value = "/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		productService.deleteProduct(productId);
		
	}
	
	@GetMapping(value = "/category-filter")
	public List<Product> filterByCategory(@PathParam("category") String category){
		return productService.filterByCategory(category);
	}

}
