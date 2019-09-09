package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.model.ProdutoGenerico;
import com.ufpb.geekspace.repository.ProductRepository;

@Service
public class ProductGenericService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProdutoGenerico> retrievAllProduct() {
		return productRepository.findAll();
	}
	
	public ProdutoGenerico retrieveOneProduct(long productID) {
		return productRepository.getOne(productID);
	}
	
	public ResponseEntity<?> createProduct(ProdutoGenerico product) {
		ProdutoGenerico createdProduct = productRepository.save(product);
		return new ResponseEntity<ProdutoGenerico>(createdProduct, HttpStatus.OK);
	}
	
	public ResponseEntity<?> editProduct(ProdutoGenerico product) {
		ProdutoGenerico createdProduct = productRepository.save(product);
		return new ResponseEntity<ProdutoGenerico>(createdProduct, HttpStatus.OK);
	}
	
	public void deleteProduct(long productID) {
		productRepository.deleteById(productID);
		
	}

}
