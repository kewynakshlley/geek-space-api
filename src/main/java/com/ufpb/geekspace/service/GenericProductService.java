package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.GenericProduct;
import com.ufpb.geekspace.repository.GenericProductRepository;
import com.ufpb.geekspace.util.ProductUtil;

@Service
public class GenericProductService {

	@Autowired
	private GenericProductRepository productRepository;

	public List<GenericProduct> retrievAllProduct() {
		return productRepository.findAll();
	}

	public GenericProduct retrieveOneProduct(long productID) {
		return productRepository.getOne(productID);
	}

	public ResponseEntity<?> createProduct(GenericProduct product) {
		GenericProduct createdProduct = productRepository.save(product);
		return new ResponseEntity<GenericProduct>(createdProduct, HttpStatus.OK);
	}

	public ResponseEntity<?> editProduct(GenericProduct product) {
		GenericProduct createdProduct = productRepository.save(product);
		return new ResponseEntity<GenericProduct>(createdProduct, HttpStatus.OK);
	}

	public void deleteProduct(long productID) throws DataNotFoundException {
		GenericProduct gp = productRepository.getOne(productID);
		if(gp == null)
			throw new DataNotFoundException(ProductUtil.PRODUCT_NOT_FOUND);
		productRepository.delete(gp);

	}

}
