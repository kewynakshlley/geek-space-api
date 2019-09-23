package com.ufpb.geekspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ufpb.geekspace.exception.DataNotFoundException;
import com.ufpb.geekspace.model.Product;
import com.ufpb.geekspace.model.ShirtProduct;
import com.ufpb.geekspace.repository.ShirtProductRepository;
import com.ufpb.geekspace.util.ProductUtil;

@Service
public class ShirtProductService {

	@Autowired
	ShirtProductRepository shirtRepository;

	public List<ShirtProduct> retrievAllShirts() {
		return shirtRepository.findAll();
	}

	public ShirtProduct retrieveOneShirtProduct(long shirtId) {
		return shirtRepository.getOne(shirtId);
	}

	public ResponseEntity<?> createShirtProduct(ShirtProduct shirt) {
		ShirtProduct createdShirt = shirtRepository.save(shirt);
		return new ResponseEntity<ShirtProduct>(createdShirt, HttpStatus.OK);
	}

	public ResponseEntity<?> editShirtProduct(ShirtProduct shirt) {
		ShirtProduct createdShirt = shirtRepository.save(shirt);
		return new ResponseEntity<ShirtProduct>(createdShirt, HttpStatus.OK);
	}

	public void deleteShirtCamisa(long shirtId) throws DataNotFoundException {
		ShirtProduct sp = shirtRepository.getOne(shirtId);
		if(sp == null)
			throw new DataNotFoundException(ProductUtil.PRODUCT_NOT_FOUND);
		shirtRepository.delete(sp);
	}

	public List<Product> filterByGenre(String genre) {
		return shirtRepository.findByGenre(genre);
	}

	public List<Product> filterByColor(String color) {
		return shirtRepository.findByColor(color);
	}

	public List<Product> filterByColorAndGenre(String color, String genre) {
		return shirtRepository.findByColorAndGenre(color, genre);
	}
}
