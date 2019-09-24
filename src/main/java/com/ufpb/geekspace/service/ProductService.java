package com.ufpb.geekspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> retrievAllProduct() {

		return productRepository.findAll();
	}

	public Optional<Product> retrieveOneProduct(long productID) {
		return productRepository.findById(productID);
	}

	public ResponseEntity<?> createProduct(Product product) {
		Product createdProduct = productRepository.save(product);
		return new ResponseEntity<Product>(createdProduct, HttpStatus.OK);
	}

	public ResponseEntity<?> editProduct(Product product) {
		Product createdProduct = productRepository.save(product);
		return new ResponseEntity<Product>(createdProduct, HttpStatus.OK);
	}

	public void deleteProduct(long productID) {
		productRepository.deleteById(productID);

	}

	public List<Product> filterByCategory(String category) {
		return productRepository.findByCategory(category);
	}

}
