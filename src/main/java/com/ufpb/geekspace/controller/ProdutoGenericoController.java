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

import com.ufpb.geekspace.model.ProdutoGenerico;
import com.ufpb.geekspace.service.ProductGenericService;

@RestController
@RequestMapping(value = "productGeneric")
public class ProdutoGenericoController {

	@Autowired
	private ProductGenericService produtoGenericservice;
	
	@GetMapping
	public List<ProdutoGenerico> retrievAllProduct(){
		return produtoGenericservice.retrievAllProduct();
	}
	
	@GetMapping(value = "/{productId}")
	public ProdutoGenerico retrieveOneProduct(@PathVariable long productId) {
		return produtoGenericservice.retrieveOneProduct(productId);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<?> createProduct(@RequestBody ProdutoGenerico product) {
		return produtoGenericservice.createProduct(product);
	}
	
	@PutMapping
	public void editProduct(@RequestBody ProdutoGenerico product) {
		produtoGenericservice.editProduct(product);
	}
	
	@DeleteMapping(value = "/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		produtoGenericservice.deleteProduct(productId);;
	}
}
